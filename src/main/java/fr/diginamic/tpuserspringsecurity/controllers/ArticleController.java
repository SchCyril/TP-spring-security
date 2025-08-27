package fr.diginamic.tpuserspringsecurity.controllers;


import fr.diginamic.tpuserspringsecurity.entities.Article;
import fr.diginamic.tpuserspringsecurity.repositories.ArticleRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ArticleController {

    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @PostMapping("/register-article")
    public String registerArticle(@ModelAttribute Article article, Authentication authentication, RedirectAttributes redirectAttributes) {
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        articleRepository.save(new Article(article.getTitre(), article.getContenu()));
        redirectAttributes.addFlashAttribute("message",
                "Article " + article.getTitre() + " avec le contenu " + article.getContenu() + " ajouté par " + username);
        return "redirect:/validation-article";
    }
}
