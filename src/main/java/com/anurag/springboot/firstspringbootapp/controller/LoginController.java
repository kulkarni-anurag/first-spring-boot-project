package com.anurag.springboot.firstspringbootapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping(value = "/login")
    public String sayHelloWorld(@RequestParam String name, ModelMap model){
        model.addAttribute("name", name);
        return "login";
    }
}
