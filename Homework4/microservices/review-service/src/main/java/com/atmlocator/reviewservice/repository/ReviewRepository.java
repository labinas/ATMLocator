package com.atmlocator.reviewservice.repository;/*
    Created by Labina on 31-Jan-22
*/

import com.atmlocator.reviewservice.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByAtmId(Long atmId);
}
