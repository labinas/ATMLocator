package dians.atmlocator.repository;

import dians.atmlocator.model.ApplicationUser;
import dians.atmlocator.model.Atm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    Optional<ApplicationUser> findUserByUsername(String username);
    Optional<ApplicationUser> findApplicationUserByEmail (String email);
}
