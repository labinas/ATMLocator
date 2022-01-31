package com.atmlocator.reviewservice.model;/*
    Created by Labina on 31-Jan-22
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewList {
    List<Review> reviews;
}
