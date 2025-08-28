package fr.diginamic.tpuserspringsecurity.controllers;

import fr.diginamic.tpuserspringsecurity.entities.UserApp;
import fr.diginamic.tpuserspringsecurity.services.JwtAuthenticationService;
import org.springframework.web.bind.annotation.*;

@RestController
public class JwtController {

    private final JwtAuthenticationService jwtService;

    public JwtController(JwtAuthenticationService jwtService) {
        this.jwtService = jwtService;
    }

    // POST /login
    @PostMapping("/login")
    public String login(@RequestBody UserApp user) {
        // pas de vérification pour l'instant
        return "Utilisateur reçu : " + user.getEmail();
    }

    // GET /create-jwt?username=Alice
    @GetMapping("/create-jwt")
    public String createJwt(@RequestParam String username) {
        return jwtService.generateToken(username);
    }

    // GET /get-jwt?username=Alice
    @GetMapping("/get-jwt")
    public String getJwt(@RequestParam String username) {
        return jwtService.generateToken(username);
    }
}
