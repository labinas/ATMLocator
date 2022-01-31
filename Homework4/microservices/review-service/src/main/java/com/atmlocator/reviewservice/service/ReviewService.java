package com.atmlocator.reviewservice.service;/*
    Created by Labina on 31-Jan-22
*/

import com.atmlocator.reviewservice.model.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {
    List<Review> findAllByAtm(Long atmId);
    Review saveReview(Review review);
}
