package fr.diginamic.tpuserspringsecurity.controllers;

import fr.diginamic.tpuserspringsecurity.entities.Article;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class PageController {

    @GetMapping("/register-user")
    public String registerUser() {
        return "register-user";
    }

    @GetMapping("/register-article")
    public  String registerArticle() {
        return "register-article";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/validation-article")
    public String validationArticle() {
        return "validation-article";
    }

}
