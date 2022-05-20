package com.anurag.springboot.firstspringbootapp.controller;

import java.util.Date;

import com.anurag.springboot.firstspringbootapp.service.TodoService;
import com.anurag.springboot.firstspringbootapp.todo.Todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
        model.addAttribute("todo", new Todo());
        return "todo";
    }

    @PostMapping(value = "/addtodo")
    public String handleAddTodo(@ModelAttribute("todo") Todo todo, BindingResult result, ModelMap model){
        if(result.hasErrors()){
            return "todo";
        }
        String user = (String) model.get("username");
        service.addTodo(user, todo.getDesc(), new Date(), false);
        return "redirect:list-todos";
    }
}
