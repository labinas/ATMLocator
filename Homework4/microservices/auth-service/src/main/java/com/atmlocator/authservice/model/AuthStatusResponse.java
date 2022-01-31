package com.atmlocator.authservice.model;
/*
    Created by Labina on 30-Jan-22
*/

import com.atmlocator.authservice.model.VO.SuccessFailure;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthStatusResponse {
    SuccessFailure status;
    String message;
}
