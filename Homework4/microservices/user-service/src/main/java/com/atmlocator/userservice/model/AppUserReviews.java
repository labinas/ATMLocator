package com.atmlocator.userservice.model;/*
    Created by Labina on 29-Jan-22
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AppUserReviews {

    @Id
    Long id;
    Long reviewId;

    public AppUserReviews(Long reviewId) {
        this.reviewId = reviewId;
    }
}
