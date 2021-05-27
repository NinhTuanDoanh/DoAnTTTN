package com.example.demo.services;


import com.example.demo.Model.dto.UserDto;
import com.example.demo.entity.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<Users> getListUser();
    String addUserByAdmin(UserDto userDto);
    void deleteAccountById(Long id);
}
