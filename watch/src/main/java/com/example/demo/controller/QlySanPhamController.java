package com.example.demo.controller;




import com.example.demo.Model.dto.ProductsDto;
import com.example.demo.entity.Manufacturer;
import com.example.demo.entity.Products;
import com.example.demo.services.ManufacturerService;
import com.example.demo.services.ProductImageService;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Controller
public class QlySanPhamController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ManufacturerService manufacturerService;
    @Autowired
    private ProductImageService productImageService;
    @GetMapping("/productmanager")
    public String adminhome(Model model){
        model.addAttribute("productInfo",productService.listAdminProducts());
        model.addAttribute("brandList",manufacturerService.listManufacturers());
        return "productmanager";
    }
    @GetMapping("/addproduct")
    public String addProduct(Model model)
    {
        model.addAttribute("brandList",manufacturerService.listManufacturers());
        model.addAttribute("products",new ProductsDto());
        return "addproduct";
    }
    @PostMapping("/addproduct1")
    public String addProduct(@ModelAttribute(value="products") ProductsDto productsDto,Model model,@RequestParam("files") MultipartFile[] files){
        return productService.createProductByAdmin(productsDto,files);
    }
    @GetMapping("/deleteproduct")
    public String deleteProduct(Model model,@RequestParam Long id){

        productImageService.deleteProductImage(id);
        productService.deleteProductById(id);
        return "redirect:/productmanager";
    }
    @GetMapping("chinhsuasanpham/{productid}")
    public String updateproduct(@PathVariable("productid") Long productid, Model model)
    {
        Products products=null;
        try {
            products = productService.getProductById(productid);
            List<Manufacturer> manufacturers= manufacturerService.listManufacturers();
            model.addAttribute("productdetai",products);
            model.addAttribute("brandlist",manufacturers);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Chinhsuasanpham";
    }

}
