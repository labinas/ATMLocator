package com.atmlocator.authservice.service.impl;
/*
    Created by Labina on 29-Jan-22
*/

import com.atmlocator.authservice.model.AuthLoginRequest;
import com.atmlocator.authservice.model.AuthSignupRequest;
import com.atmlocator.authservice.model.AuthStatusResponse;
import com.atmlocator.authservice.model.VO.AppUserVO;
import com.atmlocator.authservice.model.VO.SuccessFailure;
import com.atmlocator.authservice.service.AuthService;
import com.atmlocator.authservice.service.CookieUtilities;
import com.atmlocator.authservice.service.JWTUtilities;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final JWTUtilities jwtUtilities;
    private final RestTemplate restTemplate;
    private final PasswordEncoder passwordEncoder;
    private final CookieUtilities cookieUtilities;

    @Override
    public Map<AuthStatusResponse, HttpHeaders> login(AuthLoginRequest request) {
        HttpHeaders headers = new HttpHeaders();
        Map<AuthStatusResponse, HttpHeaders> response = new HashMap<>();
        Map<String,String> pathVariables = new HashMap<>();
        pathVariables.put("username", request.getUsername());
        AppUserVO user = restTemplate.getForObject("http://user-service/users/user/{username}", AppUserVO.class, pathVariables);
        if(user != null && passwordEncoder.matches(request.getPassword(), user.getPassword())){
           AuthStatusResponse status = new AuthStatusResponse(SuccessFailure.SUCCESS, "Authentication is successful!");
           headers = this.createJWTCookie(headers, user);
           response.put(status, headers);
        }else{
            AuthStatusResponse status = new AuthStatusResponse(SuccessFailure.FAILURE, "Authentication has failed!");
            response.put(status,headers);
        }

        return response;
    }

    @Override
    public Map<AuthStatusResponse, HttpHeaders> register(AuthSignupRequest request) {
        AppUserVO user = new AppUserVO(null, request.getUsername(), passwordEncoder.encode(request.getPassword()), request.getEmail(), "ROLE_USER");
        AppUserVO responseUser = restTemplate.postForObject("http://user-service/users/register", user, AppUserVO.class);
        HttpHeaders headers = new HttpHeaders();
        Map<AuthStatusResponse, HttpHeaders> response = new HashMap<>();

        AuthStatusResponse status = new AuthStatusResponse(SuccessFailure.SUCCESS, "Authentication is successful!");
        headers = this.createJWTCookie(headers, responseUser);
        response.put(status, headers);
        return response;
    }

    @Override
    public HttpHeaders createJWTCookie(HttpHeaders headers, AppUserVO user) {
        String access = jwtUtilities.generate(user,"ACCESS");
        String refresh = jwtUtilities.generate(user,"REFRESH");
        headers.add(HttpHeaders.SET_COOKIE, cookieUtilities.createAccessTokenCookie(access,jwtUtilities.getTokenDuration(access)).toString());
        headers.add(HttpHeaders.SET_COOKIE, cookieUtilities.createRefreshTokenCookie(refresh, jwtUtilities.getTokenDuration(refresh)).toString());
        headers.add(HttpHeaders.SET_COOKIE, cookieUtilities.createUserIDCookie(user.getId(), jwtUtilities.getTokenDuration(access)).toString());
        headers.add(HttpHeaders.SET_COOKIE, cookieUtilities.createUsernameCookie(user.getUsername(),jwtUtilities.getTokenDuration(access)).toString());
        return headers;
    }

    @Override
    public HttpHeaders logout() {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.SET_COOKIE, cookieUtilities.deleteAccessTokenCookie().toString());
        headers.add(HttpHeaders.SET_COOKIE, cookieUtilities.deleteRefreshTokenCookie().toString());
        headers.add(HttpHeaders.SET_COOKIE, cookieUtilities.deleteUsernameCookie().toString());
        headers.add(HttpHeaders.SET_COOKIE, cookieUtilities.deleteUserIDCookie().toString());
        return headers;
    }
}
