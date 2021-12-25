package dians.atmlocator.web.controller;

import dians.atmlocator.model.Atm;
import dians.atmlocator.service.AtmService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DataController {

    private final AtmService atmService;

    public DataController(AtmService atmService) {
        this.atmService = atmService;
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


}
