package dians.atmlocator.service;


import dians.atmlocator.model.BankInfo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface BankInfoService {
    Optional<BankInfo> findByBank(String bank);
}
