package com.example.demo.controller;

import com.example.demo.Model.dto.OrderDto;
import com.example.demo.Model.dto.UserLoginDto;
import com.example.demo.services.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CheckoutController {
    @Autowired
    private CheckoutService checkoutService;
    @PostMapping("/save")
    public String saveCheckOut(@ModelAttribute(name = "orderDto") OrderDto orderDto, Model model) throws Exception {
        return checkoutService.saveOrder(orderDto);
    }
}
