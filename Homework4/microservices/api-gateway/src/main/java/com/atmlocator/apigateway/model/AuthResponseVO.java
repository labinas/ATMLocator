package com.atmlocator.apigateway.model;/*
    Created by Labina on 30-Jan-22
*/

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthResponseVO {
    private String accessToken;
    private String refreshToken;
}
