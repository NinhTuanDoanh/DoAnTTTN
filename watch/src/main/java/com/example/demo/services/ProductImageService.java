package com.example.demo.services;


import com.example.demo.repository.ProductImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductImageService {
    @Autowired
    private ProductImageRepository productImageRepository;
    public void deleteProductImage(Long id)
    {
        productImageRepository.deleteProductImageByImageid(id);
    }

}
