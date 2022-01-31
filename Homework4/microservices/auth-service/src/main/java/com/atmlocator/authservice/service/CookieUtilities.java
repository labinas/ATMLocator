package com.atmlocator.authservice.service;/*
    Created by Labina on 30-Jan-22
*/

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpCookie;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;

@Component
public class CookieUtilities {

    @Value("${jwt.accessCookieName}")
    String accessCookieName;
    @Value("${jwt.refreshCookieName}")
    String refreshCookieName;

    public HttpCookie createAccessTokenCookie(String token, Long duration) {
        return ResponseCookie.from(accessCookieName, token)
                .maxAge(duration)
                .httpOnly(true)
                .path("/")
                .build();
    }

    public HttpCookie createRefreshTokenCookie(String token, Long duration) {
        return ResponseCookie.from(refreshCookieName, token)
                .maxAge(duration)
                .httpOnly(true)
                .path("/")
                .build();
    }

    public HttpCookie createUsernameCookie(String username, Long duration){
        return ResponseCookie.from("usernameCookie", username)
                .maxAge(duration)
                .httpOnly(false)
                .path("/")
                .build();
    }

    public HttpCookie createUserIDCookie(Long userID, Long duration){
        return ResponseCookie.from("userIDCookie", userID.toString())
                .maxAge(duration)
                .httpOnly(false)
                .path("/")
                .build();
    }

    public HttpCookie deleteAccessTokenCookie() {
        return ResponseCookie.from(accessCookieName, "").maxAge(0).httpOnly(true).path("/").build();
    }

    public HttpCookie deleteRefreshTokenCookie() {
        return ResponseCookie.from(refreshCookieName, "").maxAge(0).httpOnly(true).path("/").build();
    }

    public HttpCookie deleteUsernameCookie(){
        return ResponseCookie.from("usernameCookie", "").maxAge(0).httpOnly(true).path("/").build();
    }

    public HttpCookie deleteUserIDCookie(){
        return ResponseCookie.from("userIDCookie", "").maxAge(0).httpOnly(true).path("/").build();
    }



}
