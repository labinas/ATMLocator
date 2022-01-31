package com.atmlocator.apigateway.config;

import com.auth0.jwt.interfaces.Claim;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.*;

@RefreshScope
@Component
@AllArgsConstructor
@Slf4j
public class AuthenticationFilter implements GatewayFilter {

    private final RouterValidator routerValidator;
    private final JWTUtilities jwtUtilities;


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();

        if(routerValidator.isSecured(request)){
            if(this.isAccessCookieMissing(request) && this.isAuthMissing(request)){
                return this.onError(exchange, "Authorization failed!", HttpStatus.FOUND);
            }
            String token = this.getCookieToken(request);
            if(jwtUtilities.isInvalid(token)){
                return this.onError(exchange, "Authorization failed!", HttpStatus.FOUND);
            }
            this.populateRequestWithHeaders(exchange,token);
        }
        log.info("return chain filter");
        return chain.filter(exchange);
    }

    private Mono<Void> onError(ServerWebExchange exchange, String err, HttpStatus httpStatus) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(httpStatus);
        response.getHeaders().set("ErrorMsg", err);
        response.getHeaders().set("Location", "/login");
        return response.setComplete();
    }

    private String getAuthHeader(ServerHttpRequest request) {
        return request.getHeaders().getOrEmpty("Authorization").get(0);
    }

    private String getCookieToken(ServerHttpRequest request){
        String accessToken = request.getCookies().get("accessCookie").get(0).getValue();
        return accessToken;
    }

    private boolean isAuthMissing(ServerHttpRequest request) {
        return !request.getHeaders().containsKey("Authorization");
    }

    private boolean isAccessCookieMissing(ServerHttpRequest request){
        return !request.getHeaders().containsKey("Cookie");
    }

    private void populateRequestWithHeaders(ServerWebExchange exchange, String token) {
        String subject = jwtUtilities.getSubjectFromToken(token);
        log.info("populate");
        Map<String, Claim> claims = jwtUtilities.getAllClaimsFromToken(token);
        exchange.getRequest().mutate()
                .header("username", subject)
                .header("role", String.valueOf(claims.get("role")))
                .build();
    }
}
