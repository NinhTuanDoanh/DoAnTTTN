package com.example.demo.controller;


import com.example.demo.Model.dto.OrderDto;
import com.example.demo.entity.Products;
import com.example.demo.services.BrandService;
import com.example.demo.services.ProductService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ProductService productService;
    @Autowired
    private BrandService brandService;

    @GetMapping("/")
    public String home(Model model){
        List<Products> products=productService.listProducts();
        model.addAttribute("brand",brandService.listManufacturer());
        model.addAttribute("products",products);
        return "index-5";
    }

    @GetMapping("/productdetails")
    public String productdetails(){return "product-details-6";}
    @GetMapping("/shop")
    public String shop(Model model,@RequestParam(defaultValue = "1",required = false) Integer pageNo,
                       @RequestParam(defaultValue = "8",required = false) Integer pageSize){
        Page<Products> products=productService.listProductsPageable(pageNo,pageSize);
        List < Products > listproducts = products.getContent();
        model.addAttribute("products",listproducts);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", products.getTotalPages());
        model.addAttribute("totalItems", products.getTotalElements());

        return "shop";
    }
    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("brand",brandService.listManufacturer());
        return "about";
    }
    @GetMapping("/myaccount")
    public String myAccount(Model model){
        model.addAttribute("brand",brandService.listManufacturer());
        return "my-account";
    }
    @GetMapping("/contact")
    public String contact(Model model)
    {
        model.addAttribute("brand",brandService.listManufacturer());
        return "contact";
    }
    @GetMapping("/cart")
    public String cart(Model model){

        model.addAttribute("brand",brandService.listManufacturer());
        return "cart-page";
    }
    @GetMapping("/checkout")
    public String checkout(Model model){
        model.addAttribute("orderDto",new OrderDto());
        model.addAttribute("brand",brandService.listManufacturer());
        return "checkout";
    }

}
