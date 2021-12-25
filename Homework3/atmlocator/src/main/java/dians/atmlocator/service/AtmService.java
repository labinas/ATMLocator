package dians.atmlocator.service;

import dians.atmlocator.model.Atm;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface AtmService {
    List<Atm> getAllAtms();
    Optional<Atm> findById(Long id);
    List<Atm> findAtmsByBankName (String bank);
}
