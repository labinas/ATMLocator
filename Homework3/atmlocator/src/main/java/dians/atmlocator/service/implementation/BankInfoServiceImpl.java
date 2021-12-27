package dians.atmlocator.service.implementation;

import dians.atmlocator.model.BankInfo;
import dians.atmlocator.repository.BankInfoRepository;
import dians.atmlocator.service.BankInfoService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankInfoServiceImpl implements BankInfoService {

    private final BankInfoRepository bankInfoRepository;

    public BankInfoServiceImpl(BankInfoRepository bankInfoRepository) {
        this.bankInfoRepository = bankInfoRepository;
    }

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
}
