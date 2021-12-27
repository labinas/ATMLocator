package dians.atmlocator.service.implementation;

import dians.atmlocator.model.Atm;
import dians.atmlocator.model.Review;
import dians.atmlocator.repository.ReviewRepository;
import dians.atmlocator.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> findByAtm(Atm atm) {
        return reviewRepository.findAllByAtm(atm);
    }

    @Override
    public void save(Review review) {
        reviewRepository.save(review);
    }
}
