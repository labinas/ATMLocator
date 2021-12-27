package dians.atmlocator.service.implementation;

import dians.atmlocator.model.Atm;
import dians.atmlocator.model.Review;
import dians.atmlocator.repository.AtmRepository;
import dians.atmlocator.service.AtmService;
import org.springframework.data.domain.Sort;
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

    @Override
    public List<Atm> sortByAlphabeticalOrder() {
        return atmRepository.findAll(Sort.by(Sort.Direction.ASC, "nameEn"));
    }

    @Override
    public List<Atm> sortByRating() {
        return atmRepository.findAll(Sort.by(Sort.Direction.ASC, "rating"));
    }

    @Override
    public void setNewRating(Atm atm) {
        int ratings = atm.getReviews().stream().map(Review::getRating).reduce(0, Integer::sum);
        if(atm.getReviews().size() > 0)
            atm.setRating(ratings/atm.getReviews().size());
        else atm.setRating(ratings);
        atmRepository.save(atm);
    }

    @Override
    public List<Review> getReviews(Long id) {
        return atmRepository.getById(id).getReviews();
    }
}
