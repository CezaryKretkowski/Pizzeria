package com.example.Pizzeria.controllers;

import com.example.Pizzeria.dto.CreatePizzaDto;
import com.example.Pizzeria.dto.UpdatePizzaDto;
import com.example.Pizzeria.services.admin.MarkdownService;
import com.example.Pizzeria.services.home.PizzaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@AllArgsConstructor
public class AdminPageController {
    private final PizzaService pizzaService;
    private final MarkdownService markdownService;
    @GetMapping("/admin_page")
    public String  getPage(Model model){
        var pizzas= pizzaService.getAll();
        model.addAttribute("pizzas",pizzas);
        model.addAttribute("content",markdownService.getMarkDownCode("about_us.md"));

        return "admin_page";
    }

    @PostMapping("/add_pizza")
    public RedirectView add_Pizza(@RequestParam("file") MultipartFile file, @ModelAttribute CreatePizzaDto createPizzaDto, Model model){
        pizzaService.add(createPizzaDto,file);
        return new RedirectView("/admin_page");
    }

    @PostMapping("/update_info")
    public RedirectView updateStaticFile(@RequestParam String content){
        markdownService.saveCode(content);
        return new RedirectView("/admin_page");
    }

    @PostMapping("/update_Pizza")
    public RedirectView update_Pizza(@RequestParam("file") MultipartFile file, @ModelAttribute UpdatePizzaDto updatePizzaDto, Model model){
        pizzaService.update(updatePizzaDto,file);
        return new RedirectView("/admin_page");
    }
}
