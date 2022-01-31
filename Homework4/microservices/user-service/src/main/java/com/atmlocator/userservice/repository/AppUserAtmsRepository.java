package com.atmlocator.userservice.repository;/*
    Created by Labina on 31-Jan-22
*/

import com.atmlocator.userservice.model.AppUserAtms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserAtmsRepository extends JpaRepository<AppUserAtms, Long> {

}
