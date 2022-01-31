package com.atmlocator.bankservice.service.impl;/*
    Created by Labina on 31-Jan-22
*/

import com.atmlocator.bankservice.model.Atm;
import com.atmlocator.bankservice.model.BankInfo;
import com.atmlocator.bankservice.model.VO.ReviewList;
import com.atmlocator.bankservice.model.VO.ReviewVO;
import com.atmlocator.bankservice.repository.AtmRepository;
import com.atmlocator.bankservice.repository.BankInfoRepository;
import com.atmlocator.bankservice.service.BankService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BankServiceImpl implements BankService {

    private final AtmRepository atmRepository;
    private final BankInfoRepository bankInfoRepository;
    private final RestTemplate restTemplate;

    @Override
    public Optional<BankInfo> findByBank(String bank) {
        String contains = "";
        if(bank.contains("Komercijalna")) contains = "Komercijalna";
        if(bank.contains("NLB")) contains = "NLB";
        if(bank.contains("Ohridska")) contains = "Ohridska";
        if(bank.contains("ProCredit")) contains = "ProCredit";
        if(bank.contains("Silk")) contains = "Silk";
        if(bank.contains("Stopanska")) contains = "Stopanska";
        if(bank.contains("Bitola")) contains = "Bitola";
        if(bank.contains("Uni")) contains = "Uni";
        if(bank.contains("Halk")) contains = "Halk";
        if(bank.contains("Sparkasse")) contains = "Sparkasse";

        return bankInfoRepository.findFirstByBankContaining(contains);
    }

    @Override
    public List<Atm> getAllAtms() {
        return atmRepository.findAll();
    }

    @Override
    public Optional<Atm> findById(Long id) {
        return atmRepository.findById(id);
    }

    @Override
    public List<Atm> findAtmsByBankName(String bank) {
        return atmRepository.findAtmsByNameEnContaining(bank);
    }

    @Override
    public List<Atm> sortByAlphabeticalOrder() {
        return atmRepository.findAll(Sort.by(Sort.Direction.ASC, "nameEn"));
    }

    @Override
    public List<Atm> sortByRating() {
        return atmRepository.findAll(Sort.by(Sort.Direction.ASC, "rating"));
    }

    @Override
    public void setNewRating(Long atmId) {
        Atm atm = atmRepository.getById(atmId);
        List<ReviewVO> reviews = this.getReviews(atmId);
        int ratings = reviews.stream().map(ReviewVO::getRating).reduce(0, Integer::sum);
        if(reviews.size() > 0)
            atm.setRating(ratings/reviews.size());
        else atm.setRating(ratings);
        atmRepository.save(atm);
    }

    @Override
    public List<ReviewVO> getReviews(Long id) {
        ReviewList list = restTemplate.getForObject("http://review-service/reviews/atm/" + id, ReviewList.class);
        if(list !=null)
            return list.getReviews();
        else return Collections.emptyList();
    }

    @Override
    public List<Atm> findByIds(List<Long> ids) {
        return atmRepository.findAllById(ids);
    }
}
