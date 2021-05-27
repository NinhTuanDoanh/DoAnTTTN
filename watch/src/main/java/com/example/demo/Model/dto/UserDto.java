package com.example.demo.Model.dto;

import lombok.Data;

@Data
public class UserDto {
    private String name;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String role;
}
