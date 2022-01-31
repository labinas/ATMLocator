package com.atmlocator.bankservice.repository;
/*
    Created by Labina on 31-Jan-22
*/

import com.atmlocator.bankservice.model.Atm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtmRepository extends JpaRepository<Atm, Long> {
    List<Atm> findAtmsByNameEnContaining (String bank);
}
