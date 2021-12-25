package dians.atmlocator.service.implementation;

import dians.atmlocator.model.Atm;
import dians.atmlocator.repository.AtmRepository;
import dians.atmlocator.service.AtmService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtmServiceImpl implements AtmService {
    private final AtmRepository atmRepository;

    public AtmServiceImpl(AtmRepository atmRepository) {
        this.atmRepository = atmRepository;
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
}
