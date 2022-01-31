package com.atmlocator.apigateway.model;/*
    Created by Labina on 30-Jan-22
*/

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthStatusResponseVO {
    SuccessFailureVO status;
    String message;
}
