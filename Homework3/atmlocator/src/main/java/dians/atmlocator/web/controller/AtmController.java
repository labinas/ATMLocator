package dians.atmlocator.web.controller;

import dians.atmlocator.model.Atm;
import dians.atmlocator.service.ApplicationUserService;
import dians.atmlocator.service.AtmService;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/atm")
public class AtmController {

    private final ApplicationUserService applicationUserService;
    private final AtmService atmService;

    public AtmController(ApplicationUserService applicationUserService, AtmService atmService) {
        this.applicationUserService = applicationUserService;
        this.atmService = atmService;
    }

    @GetMapping("/all")
    public String getAllAtmPage(Model model){
        model.addAttribute("atmList", atmService.getAllAtms());
        model.addAttribute("bodyContent", "listatms");
        model.addAttribute("atmTitle", "ALL ATMs");
        return "_master";
    }

    @GetMapping("/myatms")
    public String getMyAtmPage(HttpServletRequest request, Model model){
        String user = request.getRemoteUser();
        model.addAttribute("atmList", applicationUserService.findAllAtmsByUser(user));
        model.addAttribute("bodyContent", "listatms");
        model.addAttribute("atmTitle", "MY ATMs");
        return "_master";

    }
}
