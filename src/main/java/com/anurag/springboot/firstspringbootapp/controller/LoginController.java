package com.anurag.springboot.firstspringbootapp.controller;

import com.anurag.springboot.firstspringbootapp.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    LoginService service;

    @GetMapping(value = "/login")
    public String showLoginPage(ModelMap model){
        return "login";
    }

    @PostMapping(value = "/login")
    public String handleLogin(ModelMap model, @RequestParam String username, @RequestParam String password){
        if(service.validateUser(username, password)){
            model.addAttribute("username", username);
            model.addAttribute("password", password);
            return "welcome";
        } else {
            model.addAttribute("error_message", "Invalid Credentials!");
            return "login";
        }
    }
}
