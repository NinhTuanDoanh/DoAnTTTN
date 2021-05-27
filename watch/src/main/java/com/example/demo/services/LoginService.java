package com.example.demo.services;

import com.example.demo.Model.dto.UserLoginDto;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    Boolean loginService(UserLoginDto userLoginDto);
}
