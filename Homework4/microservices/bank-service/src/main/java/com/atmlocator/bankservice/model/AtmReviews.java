package com.atmlocator.bankservice.model;/*
    Created by Labina on 31-Jan-22
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
public class AtmReviews {
    @Id
    Long id;
    Long reviewId;
}
