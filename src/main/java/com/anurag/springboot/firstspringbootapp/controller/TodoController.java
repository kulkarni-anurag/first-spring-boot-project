package com.anurag.springboot.firstspringbootapp.controller;

import com.anurag.springboot.firstspringbootapp.service.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoController {

    @Autowired
    TodoService service;

    @GetMapping(value = "/list-todos")
    public String showTodos(ModelMap model){
        model.addAttribute("todos", service.retrieveTodos("virat"));
        return "list-todos";
    }
}
