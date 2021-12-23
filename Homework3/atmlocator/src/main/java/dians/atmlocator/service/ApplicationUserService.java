package dians.atmlocator.service;

import dians.atmlocator.model.Atm;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface ApplicationUserService extends UserDetailsService {
    List<Atm> findAllAtmsByUser(String username);
}
