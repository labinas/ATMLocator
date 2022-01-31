package com.atmlocator.userservice.service.impl;/*
    Created by Labina on 29-Jan-22
*/

import com.atmlocator.userservice.model.AppUser;
import com.atmlocator.userservice.model.AppUserAtms;
import com.atmlocator.userservice.model.AppUserReviews;
import com.atmlocator.userservice.model.VO.UpdateVO;
import com.atmlocator.userservice.repository.AppUserRepository;
import com.atmlocator.userservice.service.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AppUser save(AppUser user) {
        return appUserRepository.save(user);
    }

    @Override
    public AppUser getUserById(Long id) {
        return appUserRepository.getById(id);
    }

    @Override
    public void updateUserById(Long id, UpdateVO updateVO) {
        AppUser user = this.appUserRepository.getById(id);
        if(updateVO.getTypeOfObject().equals("ATM")){
            List<AppUserAtms> list = user.getAtms();
            list.add(new AppUserAtms(updateVO.getId()));
            user.setAtms(list);
        }
        if(updateVO.getTypeOfObject().equals("REVIEW")){
            List<AppUserReviews> list = user.getReviews();
            list.add(new AppUserReviews(updateVO.getId()));
            user.setReviews(list);
        }
    }

    @Override
    public void removeFromUserById(Long id, UpdateVO updateVO) {
        AppUser user = this.appUserRepository.getById(id);
        if(updateVO.getTypeOfObject().equals("ATM")){
            List<AppUserAtms> list = user.getAtms();
            List<AppUserAtms> newList = list.stream().filter(a -> !a.getAtmId().equals(updateVO.getId())).collect(Collectors.toList());
            user.setAtms(newList);
        }
        if(updateVO.getTypeOfObject().equals("REVIEW")){
            List<AppUserReviews> list = user.getReviews();
            List<AppUserReviews> newList = list.stream().filter(a -> !a.getReviewId().equals(updateVO.getId())).collect(Collectors.toList());
            user.setReviews(newList);
        }
    }

    @Override
    public List<AppUser> getUsers() {
        return appUserRepository.findAll();
    }

    @Override
    public Optional<AppUser> findByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public Optional<AppUser> login(String username, String password) {
        return appUserRepository.findByUsernameAndPassword(username,passwordEncoder.encode(password));
    }

    @Override
    public Optional<AppUser> findByEmail(String email) {
        return appUserRepository.findByEmail(email);
    }

    @Override
    public boolean checkIfUserExists(String username) {
        return appUserRepository.findByEmail(username).isPresent() || appUserRepository.findByUsername(username).isPresent();
    }

    @Override
    public boolean checkIfAtmIsSaved(Long userId, Long atmId) {
        return appUserRepository.getById(userId).getAtms().stream().anyMatch(a -> a.getAtmId().equals(atmId));
    }
}
