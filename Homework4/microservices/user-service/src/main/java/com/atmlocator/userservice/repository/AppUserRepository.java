package com.atmlocator.userservice.repository;/*
    Created by Labina on 29-Jan-22
*/

import com.atmlocator.userservice.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository <AppUser,Long> {
    Optional<AppUser> findByUsername(String username);
    Optional<AppUser> findByEmail(String email);
    Optional<AppUser> findByUsernameAndPassword(String username, String password);
}
