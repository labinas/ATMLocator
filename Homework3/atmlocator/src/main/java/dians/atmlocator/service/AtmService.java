package dians.atmlocator.service;

import dians.atmlocator.model.Atm;
import dians.atmlocator.model.Review;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface AtmService {
    List<Atm> getAllAtms();
    Optional<Atm> findById(Long id);
    List<Atm> findAtmsByBankName (String bank);
    List<Atm> sortByAlphabeticalOrder();
    List<Atm> sortByRating();
    void setNewRating(Atm atm);
    List<Review> getReviews(Long id);
}
