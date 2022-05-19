package com.anurag.springboot.firstspringbootapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @GetMapping(value = "/login")
    @ResponseBody
    public String sayHelloWorld(){
        return "Hello World!";
    }
}
