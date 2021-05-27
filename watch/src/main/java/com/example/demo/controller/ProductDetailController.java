package com.example.demo.controller;

import com.example.demo.entity.Products;
import com.example.demo.services.BrandService;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductDetailController {
    @Autowired
    private ProductService productService;
    @Autowired
    private BrandService brandService;
    @GetMapping("/productdetail")
    public String productDetail(@RequestParam(value = "productId") Long Id, Model model)
    {
        Products products= productService.getProductById(Id);

        List<Products> relatedProduct= productService.getRelatedProduct(products.getManufacturer());
        model.addAttribute("productDetail",products);
        model.addAttribute("relatedProducts",relatedProduct);
        model.addAttribute("brand",brandService.listManufacturer());
        return "product-details-6";
    }
}
