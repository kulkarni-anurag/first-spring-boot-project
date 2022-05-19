package com.anurag.springboot.firstspringbootapp.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public boolean validateUser(String username, String password){
        if(username.equals("virat") && password.equals("dummy")){
            return true;
        }
        return false;
    }
}
