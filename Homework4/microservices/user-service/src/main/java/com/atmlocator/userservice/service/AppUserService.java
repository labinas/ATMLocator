package com.atmlocator.userservice.service;/*
    Created by Labina on 29-Jan-22
*/

import com.atmlocator.userservice.model.AppUser;
import com.atmlocator.userservice.model.VO.UpdateVO;

import java.util.List;
import java.util.Optional;

public interface AppUserService {
    AppUser save(AppUser user);
    AppUser getUserById(Long id);
    void updateUserById(Long id, UpdateVO updateVO);
    void removeFromUserById(Long id, UpdateVO updateVO);
    List<AppUser> getUsers();
    Optional<AppUser> findByUsername(String username);
    Optional<AppUser> login(String username, String password);
    Optional<AppUser> findByEmail(String email);
    boolean checkIfUserExists(String username);
    boolean checkIfAtmIsSaved (Long userId, Long atmId);
}
