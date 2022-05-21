package com.anurag.springboot.firstspringbootapp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.anurag.springboot.firstspringbootapp.service.TodoService;
import com.anurag.springboot.firstspringbootapp.todo.Todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
public class TodoController {

    @Autowired
    TodoService service;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    private String getLoggedInUser(ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
            return ((UserDetails) principal).getUsername();
        }
        return principal.toString();
    }

    @GetMapping(value = "/list-todos")
    public String showTodos(ModelMap model){
        String user = getLoggedInUser(model);
        model.addAttribute("username", user);
        model.addAttribute("todos", service.retrieveTodos(user));
        return "list-todos";
    }

    @GetMapping(value = "/addtodo")
    public String showFormTodo(ModelMap model){
        model.addAttribute("todo", new Todo());
        return "todo";
    }

    @PostMapping(value = "/addtodo")
    public String handleAddTodo(@Valid Todo todo, BindingResult result, ModelMap model){
        if(result.hasErrors()){
            return "todo";
        }
        String user = getLoggedInUser(model);
        service.addTodo(user, todo.getDesc(), todo.getTargetDate(), false);
        model.clear();
        return "redirect:list-todos";
    }

    @GetMapping(value = "/updatetodo")
    public String updateTodo(ModelMap model, @RequestParam int id){
        Todo todo = service.retrieveTodo(id);
        model.addAttribute("todo", todo);
        return "todo";
    }

    @PostMapping(value = "/updatetodo")
    public String handleUpdateTodo(@Valid Todo todo, BindingResult result, ModelMap model){
        if(result.hasErrors()){
            return "todo";
        }
        String user = getLoggedInUser(model);
        todo.setUser(user);
        service.updateTodo(todo);
        model.clear();
        return "redirect:list-todos";
    }

    @GetMapping(value = "/deletetodo")
    public String deleteTodo(ModelMap model, @RequestParam int id){
        service.deleteTodo(id);
        model.clear();
        return "redirect:list-todos";
    }
}
