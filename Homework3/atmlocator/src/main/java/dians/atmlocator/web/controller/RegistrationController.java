package dians.atmlocator.web.controller;

import dians.atmlocator.model.ApplicationUser;
import dians.atmlocator.model.UserDto;
import dians.atmlocator.service.ApplicationUserService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final ApplicationUserService applicationUserService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public RegistrationController(ApplicationUserService applicationUserService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.applicationUserService = applicationUserService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping
    public String getRegisterPage(@ModelAttribute UserDto userDto, Model model){
        model.addAttribute("userDto", userDto);
        model.addAttribute("bodyContent", "signup");
        return "_master";
    }

    @PostMapping
    public String saveUser(@Valid @ModelAttribute UserDto userDto, BindingResult bindingResult, Model model){
        if(applicationUserService.findUserByUsername(userDto.getUsername()).isPresent())
            bindingResult.addError(new FieldError("userDto", "username", "The username is already taken!"));
        if(applicationUserService.findUserByEmail(userDto.getEmail()).isPresent())
            bindingResult.addError(new FieldError("userDto", "email", "The e-mail is already in use!"));

        if(bindingResult.hasErrors()){
            model.addAttribute("bodyContent", "signup");
            return "_master";
        }

        applicationUserService
                .saveNewApplicationUser(new ApplicationUser(userDto.getUsername(),
                        bCryptPasswordEncoder.encode(userDto.getPassword()), userDto.getEmail()));

        model.addAttribute("registered", true);
        model.addAttribute("bodyContent", "signup");
        return "_master";
    }
}
