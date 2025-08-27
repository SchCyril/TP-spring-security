package fr.diginamic.tpuserspringsecurity.controllers;

import fr.diginamic.tpuserspringsecurity.entities.UserApp;
import fr.diginamic.tpuserspringsecurity.services.CustomUserDetailsService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAppController {


    private final CustomUserDetailsService customUserDetailsService;

    public UserAppController(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    @PostMapping("/register-user")
    public String registerUser(@ModelAttribute UserApp userApp) {
        customUserDetailsService.createUser(
                userApp.getEmail(),
                userApp.getPassword()
        );
        return "Utilisateur " + userApp.getEmail() + " crée";
    }

//    @GetMapping
//    public List<UserApp> findAll() {
//        return userAppRepository.findAll();
//    }
}
