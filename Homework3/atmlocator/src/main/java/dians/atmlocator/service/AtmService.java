package dians.atmlocator.service;

import dians.atmlocator.model.Atm;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AtmService {
    List<Atm> getAllAtms();
}
