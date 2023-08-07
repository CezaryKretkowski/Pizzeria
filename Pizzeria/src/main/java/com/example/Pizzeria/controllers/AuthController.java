package com.example.Pizzeria.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }
    @RequestMapping("/error-login.html")
    public String error(Model model){
        model.addAttribute("loginError", true);
        return "login";
    }
}
