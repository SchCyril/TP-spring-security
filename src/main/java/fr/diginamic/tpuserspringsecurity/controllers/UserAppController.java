package fr.diginamic.tpuserspringsecurity.controllers;

import fr.diginamic.tpuserspringsecurity.entities.UserApp;
import fr.diginamic.tpuserspringsecurity.services.CustomUserDetailsService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserAppController {


    private final CustomUserDetailsService customUserDetailsService;

    public UserAppController(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }



    @PostMapping("/register-user")
    public String registerUser(@ModelAttribute UserApp userApp, RedirectAttributes redirectAttributes) {
        customUserDetailsService.createUser(userApp.getEmail(), userApp.getPassword());
        redirectAttributes.addFlashAttribute("message", "Utilisateur " + userApp.getEmail() + " créé !");
        return "redirect:/registerUser-success";
    }


}
