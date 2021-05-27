package com.example.demo.services;

import com.example.demo.Model.dto.UserRegistrationDto;
import org.springframework.stereotype.Service;

@Service
public interface RegisterService {
     Boolean registerUser(UserRegistrationDto userRegistrationDto);
}
