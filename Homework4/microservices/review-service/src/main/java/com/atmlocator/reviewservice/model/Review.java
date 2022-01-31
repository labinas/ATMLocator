package com.atmlocator.reviewservice.model;/*
    Created by Labina on 31-Jan-22
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long userId;
    @Column(length = 4000)
    String reviewText;
    int rating;
    Long atmId;
}

