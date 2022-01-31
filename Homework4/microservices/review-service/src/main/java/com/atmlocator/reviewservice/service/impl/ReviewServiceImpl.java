package com.atmlocator.reviewservice.service.impl;/*
    Created by Labina on 31-Jan-22
*/

import com.atmlocator.reviewservice.model.Review;
import com.atmlocator.reviewservice.repository.ReviewRepository;
import com.atmlocator.reviewservice.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Override
    public List<Review> findAllByAtm(Long atmId) {
        return reviewRepository.findAllByAtmId(atmId);
    }

    @Override
    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }
}
