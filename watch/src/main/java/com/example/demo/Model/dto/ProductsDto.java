package com.example.demo.Model.dto;

import lombok.Data;

@Data
public class ProductsDto {
    private String productname;
    private String description;
    private int price;
    private int sale;
    private Long brandid;
    private int quantity;
}
