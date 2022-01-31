package com.atmlocator.authservice.service;
/*
    Created by Labina on 29-Jan-22
*/

import com.atmlocator.authservice.model.AuthLoginRequest;
import com.atmlocator.authservice.model.AuthSignupRequest;
import com.atmlocator.authservice.model.AuthStatusResponse;
import com.atmlocator.authservice.model.VO.AppUserVO;
import org.springframework.http.HttpHeaders;

import java.util.Map;


public interface AuthService {
    Map<AuthStatusResponse, HttpHeaders> login(AuthLoginRequest request);
    Map<AuthStatusResponse, HttpHeaders> register(AuthSignupRequest request);
    HttpHeaders createJWTCookie(HttpHeaders headers, AppUserVO user);
    HttpHeaders logout();
}
