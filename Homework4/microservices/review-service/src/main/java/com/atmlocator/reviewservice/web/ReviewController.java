package com.atmlocator.reviewservice.web;/*
    Created by Labina on 31-Jan-22
*/

import com.atmlocator.reviewservice.model.Review;
import com.atmlocator.reviewservice.model.ReviewList;
import com.atmlocator.reviewservice.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
@AllArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/atm/{atmId}")
    public ResponseEntity<ReviewList> getReviewsByAtm(@PathVariable Long atmId){
        ReviewList list = new ReviewList();
        list.setReviews(reviewService.findAllByAtm(atmId));
        return ResponseEntity.ok(list);
    }

    @PostMapping("/submit/{atmId}")
    public Long submitReview(@PathVariable Long atmId, @RequestBody Review review){
        review.setAtmId(atmId);
        Review saved = reviewService.saveReview(review);
        return saved.getId();
    }

}
