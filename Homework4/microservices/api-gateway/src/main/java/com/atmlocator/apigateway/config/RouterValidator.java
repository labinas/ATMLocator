package com.atmlocator.apigateway.config;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RouterValidator {

    public static final List<String> publicEndpoints = List.of(
            "/resources/**",
            "/static/**",
            "/css/**",
            "/js/**",
            "/img/**",
            "/*.css",
            "/*.js",
            "/*.png",
            "/auth/login",
            "/users/user/{username}",
            "/bank",
            "/auth/register"
    );

    public boolean isSecured(ServerHttpRequest request){
        return publicEndpoints.stream()
                .noneMatch(path -> request.getURI().getPath().contains(path));
    }
}
