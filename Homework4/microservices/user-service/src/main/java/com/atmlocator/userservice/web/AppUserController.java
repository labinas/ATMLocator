package com.atmlocator.userservice.web;
/*
    Created by Labina on 29-Jan-22
*/

import com.atmlocator.userservice.model.AppUser;
import com.atmlocator.userservice.model.AppUserAtms;
import com.atmlocator.userservice.model.VO.AtmIdsList;
import com.atmlocator.userservice.model.VO.ReviewDTO;
import com.atmlocator.userservice.model.VO.UpdateVO;
import com.atmlocator.userservice.service.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class AppUserController {

    private final AppUserService appUserService;
    private final RestTemplate restTemplate;

    @PostMapping("/register")
    public AppUser registerUser(@RequestBody AppUser user){
        return appUserService.save(user);
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody UpdateVO updateVO){
        appUserService.updateUserById(id,updateVO);
        return "";
    }

    @PostMapping("/remove/{id}")
    public String removeUser(@PathVariable Long id, @RequestBody UpdateVO updateVO){
        appUserService.removeFromUserById(id,updateVO);
        return "";
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<AppUser> getUser(@PathVariable Long id){
        return ResponseEntity.ok(appUserService.getUserById(id));
    }

    @GetMapping
    public ResponseEntity<List<AppUser>> getUsers(){
        return ResponseEntity.ok(appUserService.getUsers());
    }

    @GetMapping("/user/{username}")
    public AppUser getUserByUsername(@PathVariable String username){
        return appUserService.findByUsername(username).orElse(null);
    }

    @PostMapping("/login")
    public AppUser login(@RequestBody AppUser user){
        return appUserService.login(user.getUsername(), user.getPassword()).orElse(null);
    }

    @PostMapping("/check")
    public Boolean checkIfUserExists(@RequestBody String user){
        return appUserService.checkIfUserExists(user);
    }

    @PostMapping("/review/submit/{atmId}")
    public String submitAtmReview(@PathVariable Long atmId, @RequestBody ReviewDTO reviewDTO){
        Long reviewId = restTemplate.postForObject("http://review-service/reviews/submit/"+atmId, reviewDTO, Long.class);
        if(reviewId != null){
            UpdateVO updateVO = new UpdateVO(reviewId, "REVIEW");
            appUserService.updateUserById(reviewDTO.getUserId(), updateVO);
        }
        return "redirect:/atm/" + atmId;
    }

    @GetMapping("/{userId}/atms")
    public AtmIdsList getAtms(@PathVariable Long userId){
        List <AppUserAtms> list = appUserService.getUserById(userId).getAtms();
        List<Long> atmIds = list.stream().map(AppUserAtms::getAtmId).collect(Collectors.toList());
        return new AtmIdsList(atmIds);
    }

    @GetMapping("/checkIfSaved")
    public boolean checkAtm(@RequestParam Long user, @RequestParam Long atm){
        return appUserService.checkIfAtmIsSaved(user,atm);
    }

}
