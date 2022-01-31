package com.atmlocator.apigateway.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.Claim;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.Map;


@Component
public class JWTUtilities {

    public Map<String, Claim> getAllClaimsFromToken(String token) {
        return JWT.decode(token).getClaims();
    }

    public String getSubjectFromToken(String token){
        return JWT.decode(token).getSubject();
    }

    private boolean isTokenExpired(String token) {
        return JWT.decode(token).getExpiresAt().before(new Date(System.currentTimeMillis()));
    }

    public boolean isInvalid(String token) {
        return this.isTokenExpired(token);
    }

}
