package dians.atmlocator.repository;

import dians.atmlocator.model.Atm;
import dians.atmlocator.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByAtm(Atm atm);

}
