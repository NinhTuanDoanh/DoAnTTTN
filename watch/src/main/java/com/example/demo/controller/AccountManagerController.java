package com.example.demo.controller;

import com.example.demo.Model.dto.ProductsDto;
import com.example.demo.Model.dto.UserDto;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AccountManagerController {
    @Autowired
    private UserService userService;
    @GetMapping("/usermanager")
    public String user(Model model)
    {
        model.addAttribute("accountList",userService.getListUser());
        return "usermanager";
    }
    @GetMapping("/adduser")
    public String addUser(Model model){
        model.addAttribute("usersDto",new UserDto());
        return "addaccount";
    }

    @PostMapping("/addusermanager")
    public String addAccount(@ModelAttribute(value="usersDto") UserDto userDto, Model model){
        return userService.addUserByAdmin(userDto);
    }
    @GetMapping("/deleteaccount")
    public String deleteAccount(Model model,@RequestParam Long id){
        userService.deleteAccountById(id);
        return "redirect:/usermanager";
    }
}
