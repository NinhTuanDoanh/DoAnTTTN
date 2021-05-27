package com.example.demo.controller;

import com.example.demo.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping("/brandmanager")
    public String brandManager(Model model){
        model.addAttribute("brands",brandService.listManufacturer());
        return "brandmanager";
    }
    @GetMapping("/deletebrand")
    public String deleteProduct(Model model,@RequestParam Long id){
        brandService.deleteBrandById(id);
        return "redirect:/brandmanager";
    }
}
