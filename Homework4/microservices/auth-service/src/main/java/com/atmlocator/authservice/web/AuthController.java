package com.atmlocator.authservice.web;
/*
    Created by Labina on 29-Jan-22
*/

import com.atmlocator.authservice.model.AuthLoginRequest;
import com.atmlocator.authservice.model.AuthSignupRequest;
import com.atmlocator.authservice.model.AuthStatusResponse;
import com.atmlocator.authservice.model.VO.SuccessFailure;
import com.atmlocator.authservice.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/auth")
@Slf4j
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(final AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<AuthStatusResponse> register(@RequestBody AuthSignupRequest authRequest) {
        AuthStatusResponse success = new AuthStatusResponse(SuccessFailure.SUCCESS, "Authentication is successful!");
        Map<AuthStatusResponse, HttpHeaders> response = authService.register(authRequest);

        if(response.containsKey(success))
            return ResponseEntity.ok().headers(response.get(success)).body(success);
        else
            return ResponseEntity.badRequest().build();
    }

    @PostMapping(value = "/login")
    public ResponseEntity<AuthStatusResponse> login(@RequestBody AuthLoginRequest loginRequest) {
        AuthStatusResponse success = new AuthStatusResponse(SuccessFailure.SUCCESS, "Authentication is successful!");
        Map<AuthStatusResponse, HttpHeaders> response = authService.login(new AuthLoginRequest(loginRequest.getUsername(), loginRequest.getPassword()));

        if(response.containsKey(success))
            return ResponseEntity.ok().headers(response.get(success)).body(success);
        else
            return ResponseEntity.badRequest().build();
    }

    @GetMapping(value = "/logout")
    public ResponseEntity<String> logout(){
        HttpHeaders headers = authService.logout();
        return ResponseEntity.ok().headers(headers).body("Logout successful!");
    }

}
