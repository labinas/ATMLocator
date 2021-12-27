package dians.atmlocator.repository;

import dians.atmlocator.model.BankInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankInfoRepository extends JpaRepository<BankInfo, Long> {
    Optional<BankInfo> findFirstByBankContaining (String bank);
}
