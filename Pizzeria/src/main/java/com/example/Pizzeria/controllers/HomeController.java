package com.example.Pizzeria.controllers;

import com.example.Pizzeria.services.admin.MarkdownService;
import com.example.Pizzeria.services.home.PizzaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class HomeController {
    private final PizzaService pizzaService;
    private final MarkdownService markdownService;

    @GetMapping("/")
    public String homeController(Model model){
        model.addAttribute("Pizzas",pizzaService.getAll());
        model.addAttribute("about_us_content",markdownService.getHtmlCode("about_us.md"));
        return "index";
    }
    @GetMapping("/privacy_policy")
    public String privacyPolicyController(Model model){

        model.addAttribute("content",markdownService.getHtmlCode("private_policy.md"));
        return "privacy_policy";
    }
    @GetMapping("/statute")
    public String statuteController(Model model){

        model.addAttribute("content",markdownService.getHtmlCode("statute.md"));
        return "statute";
    }
}
