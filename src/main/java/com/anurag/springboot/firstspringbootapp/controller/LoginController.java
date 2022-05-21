package com.anurag.springboot.firstspringbootapp.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping(value = "/")
    public String showHomePage(ModelMap model){
        model.addAttribute("username", getLoggedInUser(model));
        return "welcome";
    }

    private String getLoggedInUser(ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
            return ((UserDetails) principal).getUsername();
        }
        return principal.toString();
    }
}
