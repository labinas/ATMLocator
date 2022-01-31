package com.atmlocator.authservice.service;
/*
    Created by Labina on 29-Jan-22
*/

import com.atmlocator.authservice.model.VO.AppUserVO;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.Map;

@Component
public class JWTUtilities {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private String expirationTime;

    private Algorithm algorithm;

    @PostConstruct
    public void init() {
        this.algorithm = Algorithm.HMAC256(this.secret.getBytes());
    }

    public Map<String, Claim> getAllClaimsFromToken(String token) {
        return JWT.decode(token).getClaims();
    }

    public String getSubjectFromToken(String token){
        return JWT.decode(token).getSubject();
    }

    private boolean isTokenExpired(String token) {
        return JWT.decode(token).getExpiresAt().before(new Date(System.currentTimeMillis()));
    }

    public Long getTokenDuration(String token){
        return JWT.decode(token).getExpiresAt().getTime();
    }

    public boolean isInvalid(String token) {
        return this.isTokenExpired(token);
    }

    public String generate(AppUserVO user, String type) {
        long expirationTimeLong;
        if ("ACCESS".equals(type)) {
            expirationTimeLong = Long.parseLong(expirationTime) * 1000;
        } else {
            expirationTimeLong = Long.parseLong(expirationTime) * 1000 * 5;
        }
        final Date createdDate = new Date();
        final Date expirationDate = new Date(createdDate.getTime() + expirationTimeLong);

        return JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(expirationDate)
                .withClaim("id", user.getId())
                .withClaim("role", user.getAccountRole())
                .sign(algorithm);

    }

    public Boolean validateToken(String token) {
        return !isTokenExpired(token);
    }

}
