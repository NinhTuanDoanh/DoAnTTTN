package com.example.demo.Model.mapper;


import com.example.demo.Model.dto.ProductsDto;
import com.example.demo.entity.Products;
import org.springframework.util.ObjectUtils;

import java.util.Date;

public class ProductMapper {
    public static Products toProductDto(ProductsDto productsDto) throws Exception{
        if(ObjectUtils.isEmpty(productsDto)){
            throw new Exception("Chua co thong tin");
        }
        else {
            Products products=new Products();
            products.setProductname(productsDto.getProductname());
            products.setDescription(productsDto.getDescription());
            products.setCreateat(new Date());
            products.setPrice(productsDto.getPrice());
            products.setIsactive(1);
            products.setQuantity(productsDto.getQuantity());
            products.setSale(productsDto.getSale());
            products.setManufacturer(productsDto.getBrandid());
            return products;
        }
    }
}
