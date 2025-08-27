package fr.diginamic.springsecuritytp.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SecurityController {

    @GetMapping("/login")
    public String index() {
        return "login";
    }

    @GetMapping("/public")
    public String helloPublic() {
        return "hello-public";
    }

    @PostMapping("/public")
    public String helloPublicPost() {
        return "hello-public";
    }

    @GetMapping("/private")
    public String helloPrivate() {
        return "hello-private";
    }

    @GetMapping("/current-user")
    @ResponseBody
    public String currentUser(Authentication authentication) {
        return "Utilisateur connecté : " + authentication.getName();
    }

}
