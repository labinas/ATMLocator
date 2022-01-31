package com.atmlocator.bankservice.service;/*
    Created by Labina on 31-Jan-22
*/

import com.atmlocator.bankservice.model.Atm;
import com.atmlocator.bankservice.model.BankInfo;
import com.atmlocator.bankservice.model.VO.ReviewVO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BankService {
    Optional<BankInfo> findByBank(String bank);
    List<Atm> getAllAtms();
    Optional<Atm> findById(Long id);
    List<Atm> findAtmsByBankName (String bank);
    List<Atm> sortByAlphabeticalOrder();
    List<Atm> sortByRating();
    void setNewRating(Long atmId);
    List<ReviewVO> getReviews(Long id);
    List<Atm> findByIds(List<Long> ids);
}
