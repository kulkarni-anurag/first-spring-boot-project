package com.anurag.springboot.firstspringbootapp.controller;

import com.anurag.springboot.firstspringbootapp.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class LoginController {

    @Autowired
    LoginService service;

    @GetMapping(value = "/")
    public String showHomePage(ModelMap model){
        model.addAttribute("username", "virat");
        return "welcome";
    }
}
