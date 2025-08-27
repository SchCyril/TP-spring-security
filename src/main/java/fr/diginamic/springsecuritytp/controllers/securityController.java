package fr.diginamic.springsecuritytp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class securityController {

    @GetMapping("/index")
    public String index() {
        return "hello.html";
    }

    @GetMapping("/index-private")
    public String indexPrivate() {
        return "hello-private.html";
    }


}
