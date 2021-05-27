package com.example.demo.controller;


import com.example.demo.Model.dto.UserRegistrationDto;
import com.example.demo.services.BrandService;
import com.example.demo.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {
    @Autowired
    private RegisterService registerService;
    @Autowired
    private BrandService brandService;

    @GetMapping("/register")
    public String register(Model model)
    {
        model.addAttribute("userRegistrationDto",new UserRegistrationDto());
        model.addAttribute("brand",brandService.listManufacturer());
        return "register";
    }

    @PostMapping(path = "/registration")
    public String registerUser(@ModelAttribute(value = "userRegistrationDto") UserRegistrationDto userRegistrationDto,Model model)
    {
        if(registerService.registerUser(userRegistrationDto)){
            return "/index-5";
        }
        return "/index-5";
    }

}
