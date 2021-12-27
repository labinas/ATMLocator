package dians.atmlocator.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {
    @GetMapping
    public String getLoginPage(@RequestParam(required = false) String error, Model model){
        if(error != null && error.equals("true")) model.addAttribute("error", true);
        model.addAttribute("bodyContent", "login");
        return "_master";
    }
}
