package dians.atmlocator.service.implementation;

import dians.atmlocator.model.ApplicationUser;
import dians.atmlocator.model.Atm;
import dians.atmlocator.model.Review;
import dians.atmlocator.repository.ApplicationUserRepository;
import dians.atmlocator.service.ApplicationUserService;
import dians.atmlocator.service.ReviewService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationUserServiceImpl implements ApplicationUserService {
    private final ApplicationUserRepository userRepository;
    private final ReviewService reviewService;

    public ApplicationUserServiceImpl(ApplicationUserRepository userRepository, ReviewService reviewService) {
        this.userRepository = userRepository;
        this.reviewService = reviewService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException(String.format("Username: %s not found!", username)));
    }

    @Override
    public List<Atm> findAllAtmsByUser(String username) {
        ApplicationUser user = userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("Username: %s not found!", username)));
        return user.getSavedAtms();
    }

    @Override
    public Optional<ApplicationUser> findUserByEmail(String email) {
        return userRepository.findApplicationUserByEmail(email);
    }

    @Override
    public Optional<ApplicationUser> findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public void saveNewApplicationUser(ApplicationUser user) {
        userRepository.save(user);
    }

    @Override
    public List<Atm> saveAtmToUser(Atm atm, String username) throws UsernameNotFoundException {
        if(userRepository.findUserByUsername(username).isPresent()){
            ApplicationUser user = userRepository.findUserByUsername(username).get();
            List<Atm> atmList = user.getSavedAtms();
            atmList.add(atm);
            userRepository.save(user);
            return atmList;
        }
        else throw new UsernameNotFoundException(String.format("Username: %s not found!", username));
    }

    @Override
    public List<Atm> removeAtmFromUser(Atm atm, String username) {
        if(userRepository.findUserByUsername(username).isPresent()){
            ApplicationUser user = userRepository.findUserByUsername(username).get();
            List<Atm> atmList = user.getSavedAtms();
            atmList.remove(atm);
            userRepository.save(user);
            return atmList;
        }
        else throw new UsernameNotFoundException(String.format("Username: %s not found!", username));
    }

    @Override
    public boolean isAtmSaved(Atm atm, String username) throws UsernameNotFoundException{
        if(userRepository.findUserByUsername(username).isPresent()){
            return userRepository.findUserByUsername(username).get().getSavedAtms().contains(atm);
        }
        else throw new UsernameNotFoundException(String.format("Username: %s not found!", username));
    }

    @Override
    public List<Review> saveReviewToList(Review review, ApplicationUser user) {
            List<Review> reviews = user.getReviews();
            reviews.add(review);
            userRepository.save(user);
            return reviews;
    }




}
