package dians.atmlocator.web.controller;

import dians.atmlocator.model.*;
import dians.atmlocator.service.ApplicationUserService;
import dians.atmlocator.service.AtmService;
import dians.atmlocator.service.BankInfoService;
import dians.atmlocator.service.ReviewService;
import lombok.Getter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Controller
@RequestMapping("/atm")
public class AtmController {

    private final ApplicationUserService applicationUserService;
    private final AtmService atmService;
    private final BankInfoService bankInfoService;
    private final ReviewService reviewService;

    public AtmController(ApplicationUserService applicationUserService, AtmService atmService, BankInfoService bankInfoService, ReviewService reviewService) {
        this.applicationUserService = applicationUserService;
        this.atmService = atmService;
        this.bankInfoService = bankInfoService;
        this.reviewService = reviewService;
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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String user = authentication.getName();
        model.addAttribute("atmList", applicationUserService.findAllAtmsByUser(user));
        model.addAttribute("bodyContent", "listatms");
        model.addAttribute("atmTitle", "MY ATMs");
        return "_master";

    }

    @GetMapping("/{id}")
    public String getSpecificAtmPage(@PathVariable Long id, HttpServletRequest request, Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String user = authentication.getName();
        atmService.findById(id)
                .ifPresent(atm -> {
                    BankInfo bankInfo = bankInfoService.findByBank(atm.getNameEn()).orElseGet(() -> null);
                    model.addAttribute("bankInfo", bankInfo);
                });

        atmService.findById(id).ifPresent(atm ->{
            model.addAttribute("atm", atm);
            try{
                model.addAttribute("saved", applicationUserService.isAtmSaved(atm,user));
            }catch (Exception e){
                model.addAttribute("error", e.getMessage());
            }
            model.addAttribute("reviews", reviewService.findByAtm(atm));
            atmService.setNewRating(atm);
        });
        model.addAttribute("bodyContent", "atm");
        return "_master";
    }

    @GetMapping("/add/{id}")
    public String addAtmToUser(@PathVariable Long id, Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String user = authentication.getName();
        if(atmService.findById(id).isPresent()){
            Atm atm = atmService.findById(id).get();
            model.addAttribute("atmList", applicationUserService.saveAtmToUser(atm,user));
            //model.addAttribute("saved", true);
            //model.addAttribute("atm", atm);
            //model.addAttribute("reviews", reviewService.findByAtm(atm));
        }

        return "redirect:/atm/" + id;
    }

    @GetMapping("/remove/{id}")
    public String removeAtmFromUser(@PathVariable Long id, Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String user = authentication.getName();
        if(atmService.findById(id).isPresent()){
            Atm atm = atmService.findById(id).get();
            model.addAttribute("atmList", applicationUserService.removeAtmFromUser(atm,user));
            //model.addAttribute("saved", false);
            //model.addAttribute("atm", atm);
            //model.addAttribute("reviews", reviewService.findByAtm(atm));
        }
        return "redirect:/atm/" + id;
    }

    @PostMapping("/review/submit/{id}")
    public String submitReview(@PathVariable Long id, @RequestParam String text, @RequestParam String rating, Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        ApplicationUser user = applicationUserService.findUserByUsername(username).orElseGet(() -> null);
        Atm atm = atmService.findById(id).orElseGet(() -> null);
        if(user != null && atm !=null){
            applicationUserService.saveReviewToList(new Review(user,text,Integer.parseInt(rating),atm),user);
            //atmService.setNewRating(atm);
        }

        return "redirect:/atm/" + id;
    }


}
