package dians.atmlocator.service;

import dians.atmlocator.model.Atm;
import dians.atmlocator.model.Review;

import java.util.List;

public interface ReviewService {
    List<Review> findByAtm(Atm atm);
    void save(Review review);
}
