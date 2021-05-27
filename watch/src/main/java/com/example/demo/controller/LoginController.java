package com.example.demo.controller;

import com.example.demo.Model.dto.UserLoginDto;
import com.example.demo.Model.dto.UserRegistrationDto;
import com.example.demo.services.BrandService;
import com.example.demo.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private BrandService brandService;
    @GetMapping(path = "/login")
    public String login(Model model){
        model.addAttribute("userdto",new UserLoginDto());
        model.addAttribute("brand",brandService.listManufacturer());
        return "login-register";
    }
    @PostMapping(path = "/login")
    public String login(@ModelAttribute(name = "userdto") UserLoginDto userLoginDto,Model model)
    {
        if(!loginService.loginService(userLoginDto)){
            model.addAttribute("message","Khong thanh cong");
            return "login-register";
        }
        return "redirect:/";
    }

}
