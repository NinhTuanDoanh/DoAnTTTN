package com.example.demo.Model.dto;

import lombok.Data;

@Data
public class OrderDto {
    private String receiver_address;
    private String receiver_email;
    private String receiver_name;
    private String receiver_phone;
    private int price;
    private int quantity;
}
