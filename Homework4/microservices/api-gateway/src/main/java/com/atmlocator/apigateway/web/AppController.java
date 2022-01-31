package com.atmlocator.apigateway.web;

/*
    Created by Labina on 30-Jan-22
*/

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class AppController {

    @GetMapping
    public String getHomePage(Model model){
        model.addAttribute("bodyContent", "home");
        return "_master";
    }

    @GetMapping("/login")
    public String getLoginPage(@RequestParam(required = false) String error, Model model){
        if(error != null && error.equals("true")) model.addAttribute("error", true);
        model.addAttribute("bodyContent", "login");
        return "_master";
    }

    /*@PostMapping("/login")
    public String loginUser(@ModelAttribute AuthLoginRequestVO loginRequest){
        AuthStatusResponseVO response = restTemplate.postForObject("http://auth-service/auth/login", loginRequest, AuthStatusResponseVO.class);
        if(response!=null && response.getStatus().equals(SuccessFailureVO.SUCCESS)){
            return "redirect:/";
        }else{
            return "redirect:/login";
        }
    }*/

    @GetMapping("/register")
    public String getRegisterPage(@RequestParam(required = false) String error, @RequestParam(required = false) String success, Model model){
        if(error != null && error.equals("true")) model.addAttribute("error", true);
        if(success != null && error.equals("true")) model.addAttribute("success", true);
        model.addAttribute("bodyContent", "signup");
        return "_master";
    }

    /*@PostMapping("/register")
    public String saveUser(@Valid @ModelAttribute AuthSignupRequestVO signupRequest, BindingResult bindingResult, Model model){
        Boolean usernameCheck = restTemplate.postForObject("http://user-service/users/check", signupRequest.getUsername(), Boolean.class);
        Boolean emailCheck = restTemplate.postForObject("http://user-service/users/check", signupRequest.getEmail(), Boolean.class);
        if(usernameCheck != null && usernameCheck)
            bindingResult.addError(new FieldError("userDto", "username", "The username is already taken!"));
        if(emailCheck != null && emailCheck){
            bindingResult.addError(new FieldError("userDto", "email", "The e-mail is already in use!"));
        }
        if(bindingResult.hasErrors()){
            model.addAttribute("bodyContent", "signup");
            return "_master";
        }

        AuthStatusResponseVO response = restTemplate.postForObject("http://auth-service/auth/register", signupRequest, AuthStatusResponseVO.class);
        if(response!=null && response.getStatus().equals(SuccessFailureVO.SUCCESS)){
            model.addAttribute("registered", true);
            model.addAttribute("bodyContent", "home");
        }else{
            model.addAttribute("registered", false);
            model.addAttribute("bodyContent", "signup");
        }

        return "_master";
    }*/

    @GetMapping("/atm/all")
    public String getAllAtmPage(Model model){
        model.addAttribute("bodyContent", "listatms");
        model.addAttribute("atmTitle", "ALL ATMs");
        return "_master";
    }

    @GetMapping("/atm/myatms")
    public String getMyAtmPage(Model model){
        model.addAttribute("bodyContent", "listatms");
        model.addAttribute("atmTitle", "MY ATMs");
        return "_master";
    }

    @GetMapping("/atm/{id}")
    public String getSpecificAtmPage(@PathVariable Long id, Model model){
        //TODO: da se najde bank info na ATM, da se najde dali toj ATM e zachuvan na korisnikot i da se najdat site reviews na ATM
        model.addAttribute("bodyContent", "atm");
        return "_master";
    }

}
