package com.atmlocator.authservice.model;/*
    Created by Labina on 29-Jan-22
*/

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {

    private Long userId;
    private String username;

}
