package com.example.demo.controller;

import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;
    //admin
    @GetMapping("/admin/home")
    public String homecoming(){
        return "index";
    }
}
