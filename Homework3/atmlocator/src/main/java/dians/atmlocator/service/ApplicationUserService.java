package dians.atmlocator.service;

import dians.atmlocator.model.ApplicationUser;
import dians.atmlocator.model.Atm;
import dians.atmlocator.model.Review;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface ApplicationUserService extends UserDetailsService {
    List<Atm> findAllAtmsByUser(String username);
    Optional<ApplicationUser> findUserByEmail (String email);
    Optional<ApplicationUser> findUserByUsername (String username);
    void saveNewApplicationUser (ApplicationUser user);
    List<Atm> saveAtmToUser (Atm atm, String username);
    List<Atm> removeAtmFromUser (Atm atm, String username);
    boolean isAtmSaved (Atm atm, String username);
    List<Review> saveReviewToList(Review review, ApplicationUser user);
}
