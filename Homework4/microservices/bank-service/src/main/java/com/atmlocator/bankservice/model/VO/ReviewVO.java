package com.atmlocator.bankservice.model.VO;/*
    Created by Labina on 31-Jan-22
*/

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewVO {
    Long id;
    Long userId;
    String reviewText;
    int rating;
    Long atmId;
}
