package dians.atmlocator.repository;

import dians.atmlocator.model.Atm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AtmRepository extends JpaRepository<Atm, Long> {
}
