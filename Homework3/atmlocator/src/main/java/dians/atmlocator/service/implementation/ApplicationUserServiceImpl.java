package dians.atmlocator.service.implementation;

import dians.atmlocator.model.ApplicationUser;
import dians.atmlocator.model.Atm;
import dians.atmlocator.repository.ApplicationUserRepository;
import dians.atmlocator.service.ApplicationUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ApplicationUserServiceImpl implements ApplicationUserService {
    private final ApplicationUserRepository userRepository;

    public ApplicationUserServiceImpl(ApplicationUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException(String.format("Username: %s not found!", username)));
    }

    @Override
    public List<Atm> findAllAtmsByUser(String username) {
        ApplicationUser user = userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("Username: %s not found!", username)));
        return user.getSavedAtms();
    }
}
