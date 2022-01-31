package com.atmlocator.apigateway.config;

import lombok.AllArgsConstructor;
import org.springframework.cloud.gateway.filter.factory.SpringCloudCircuitBreakerFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableHystrix
@AllArgsConstructor
public class GatewayConfig {

    private final AuthenticationFilter filter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-service", r -> r.path("/users/**")
                        .filters(f -> f.filter(filter).circuitBreaker(c -> c.setName("CircuitBreaker").setFallbackUri("forward:/userServiceFallback")))
                        .uri("lb://user-service"))
                .route("bank-service", r -> r.path("/bank/**")
                        .filters(f -> f.filter(filter).circuitBreaker(c -> c.setName("CircuitBreaker").setFallbackUri("forward:/bankServiceFallback")))
                        .uri("lb://bank-service"))
                .route("review-service", r -> r.path("/reviews/**")
                        .filters(f -> f.filter(filter).circuitBreaker(c -> c.setName("CircuitBreaker").setFallbackUri("forward:/reviewServiceFallback")))
                        .uri("lb://review-service"))
                .route("auth-service", r -> r.path("/auth/**")
                        .filters(f -> f.filter(filter).circuitBreaker(c -> c.setName("CircuitBreaker").setFallbackUri("forward:/authServiceFallback")))
                        .uri("lb://auth-service"))
                .build();
    }

}
