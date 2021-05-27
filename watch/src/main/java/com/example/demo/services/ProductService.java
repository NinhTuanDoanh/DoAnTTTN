package com.example.demo.services;

import com.example.demo.Model.dto.ProductsDto;
import com.example.demo.entity.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
     List<Products> listProducts();
     List<Products> listAdminProducts();
     void save(Products products);
     Products getProductById(Long id);
     Products getInfor(Long id);
     void deleteProductById(Long id);
     Page<Products> listProductsPageable(int pageNo, int pageSize);
     //admin
     String createProductByAdmin(ProductsDto productsDto, MultipartFile[] files);
     List<Products> getRelatedProduct(Long manufac);

}
