package dians.atmlocator.service.implementation;

import dians.atmlocator.model.Atm;
import dians.atmlocator.repository.AtmRepository;
import dians.atmlocator.service.AtmService;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
