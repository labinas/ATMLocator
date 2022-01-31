package com.atmlocator.bankservice.repository;/*
    Created by Labina on 31-Jan-22
*/

import com.atmlocator.bankservice.model.BankInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankInfoRepository extends JpaRepository<BankInfo,Long> {
    Optional<BankInfo> findFirstByBankContaining (String bank);
}
