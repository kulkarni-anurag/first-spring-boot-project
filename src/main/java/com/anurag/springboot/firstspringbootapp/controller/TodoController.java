package com.anurag.springboot.firstspringbootapp.controller;

import com.anurag.springboot.firstspringbootapp.service.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class TodoController {

    @Autowired
    TodoService service;

    @GetMapping(value = "/list-todos")
    public String showTodos(ModelMap model){
        String user = (String) model.get("username");
        model.addAttribute("todos", service.retrieveTodos(user));
        return "list-todos";
    }

    @GetMapping(value = "/addtodo")
    public String showFormTodo(ModelMap model){
        return "todo";
    }
}
