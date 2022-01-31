package com.atmlocator.bankservice.web;/*
    Created by Labina on 31-Jan-22
*/

import com.atmlocator.bankservice.model.Atm;
import com.atmlocator.bankservice.model.BankInfo;
import com.atmlocator.bankservice.model.VO.AtmIdsList;
import com.atmlocator.bankservice.model.VO.UpdateVO;
import com.atmlocator.bankservice.service.BankService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/bank")
@AllArgsConstructor
public class BankController {

    private final BankService bankService;
    private final RestTemplate restTemplate;

    @GetMapping("/atms/{id}")
    public ResponseEntity<Atm> getAtm(@PathVariable Long id){
        return bankService.findById(id)
                .map(atm -> ResponseEntity.ok().body(atm))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/atms")
    public List<Atm> getAtms(@RequestParam(required = false) String bank, @RequestParam(required = false) Long user){
        if(user != null){
            AtmIdsList response = restTemplate.getForObject("http://user-service/users/"+ user +"/atms", AtmIdsList.class);
            if(response!= null){
                List<Long> ids = response.getIds();
                return bankService.findByIds(ids);
            }
            return Collections.emptyList();
        }
        if(bank != null)
            return bankService.findAtmsByBankName(bank);
        return bankService.getAllAtms();
    }

    @GetMapping("/atms/add/{id}")
    public String addAtmToUser(@PathVariable Long id, @RequestParam Long user){
        UpdateVO updateVO = new UpdateVO(id, "ATM");
        restTemplate.postForObject("http://user-service/users/update/"+ user, updateVO, String.class);
        return "redirect:/atm/" + id;
    }

    @GetMapping("/atms/remove/{id}")
    public String removeAtmFromUser(@PathVariable Long id,@RequestParam Long user){
        UpdateVO updateVO = new UpdateVO(id, "ATM");
        restTemplate.postForObject("http://user-service/users/remove/"+ user, updateVO, String.class);
        return "redirect:/atm/" + id;
    }

    @GetMapping("/get/{name}")
    public ResponseEntity<BankInfo> getBankInfo(@PathVariable String name){
        if(bankService.findByBank(name).isPresent())
            return ResponseEntity.ok(bankService.findByBank(name).get());
        else return ResponseEntity.badRequest().build();
    }
}
