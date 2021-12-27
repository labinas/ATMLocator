package dians.atmlocator.web.controller;

import dians.atmlocator.model.Atm;
import dians.atmlocator.model.Review;
import dians.atmlocator.service.ApplicationUserService;
import dians.atmlocator.service.AtmService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DataController {

    private final AtmService atmService;
    private final ApplicationUserService applicationUserService;

    public DataController(AtmService atmService, ApplicationUserService applicationUserService) {
        this.atmService = atmService;
        this.applicationUserService = applicationUserService;
    }

    @GetMapping("/atms")
    public List<Atm> getAtms(@RequestParam(required = false) String bank){
        if(bank != null)
            return atmService.findAtmsByBankName(bank);
        return atmService.getAllAtms();
    }

    @GetMapping("/atms/{id}")
    public ResponseEntity<Atm> getAtm(@PathVariable Long id){
        return atmService.findById(id)
                .map(atm -> ResponseEntity.ok().body(atm))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/test/reviews/{id}")
    public ResponseEntity<List<Review>> getReviews(@PathVariable Long id){
        return ResponseEntity.ok().body(atmService.getReviews(id));
    }
}
