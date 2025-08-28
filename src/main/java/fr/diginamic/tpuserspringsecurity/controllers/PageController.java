package fr.diginamic.tpuserspringsecurity.controllers;

import fr.diginamic.tpuserspringsecurity.entities.UserApp;
import fr.diginamic.tpuserspringsecurity.repositories.ArticleRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageController {

    private final ArticleRepository articleRepository;

    public PageController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("/register-user")
    public String registerUser(Model model) {
        model.addAttribute("userApp", new UserApp());
        return "register-user";
    }
    @GetMapping("/registerUser-success")
    public String successPage() {
        return "registerUser-success";
    }

    @GetMapping("/register-article")
    public  String registerArticle() {
        return "register-article";
    }
    @GetMapping("/registerArticle-success")
    public String validationArticle() {
        return "registerArticle-success";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/articles")
    public String articles(Model model) {
        model.addAttribute("articles", this.articleRepository.findAll());
        return "articles";
    }

    @GetMapping("/get-cookie")
    public ResponseEntity<String> getCookie() {
        // Nom et valeur du cookie
        String cookieName = "monCookie";
        String cookieValue = "valeur123";

        // Création du cookie
        ResponseCookie tokenCookie = ResponseCookie.from(cookieName, cookieValue)
                .httpOnly(true)      // sécurité : pas accessible en JS
                .secure(false)       // à mettre à true si HTTPS
                .path("/")           // disponible sur tout le site
                .maxAge(60 * 60)     // expire après 1 heure
                .build();

        // Retour de la réponse avec le cookie dans l’en-tête
        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, tokenCookie.toString())
                .body("cookie posé avec succès");
    }

    @PostMapping("/login")
    public String log(UserApp userApp) {
        return  "login";
    }

}
