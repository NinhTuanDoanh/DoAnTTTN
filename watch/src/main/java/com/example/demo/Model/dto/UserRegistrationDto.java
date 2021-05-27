package com.example.demo.Model.dto;

import lombok.*;

@Data
public class UserRegistrationDto {
    private String email;
    private String name;
    private String password;
    private String address;
    private String phone;
}
