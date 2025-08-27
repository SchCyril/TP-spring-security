package fr.diginamic.tpuserspringsecurity.controllers;

import fr.diginamic.tpuserspringsecurity.entities.UserApp;
import fr.diginamic.tpuserspringsecurity.repositories.ArticleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}
