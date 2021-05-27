package com.example.demo.Model.mapper;


import com.example.demo.Model.dto.UserRegistrationDto;
import com.example.demo.entity.Users;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;
import java.util.Date;

public class UserMapper {
    public static Users toUserDto(UserRegistrationDto userRegistrationDto) throws Exception {

        if(ObjectUtils.isEmpty(userRegistrationDto)){
            throw new Exception("Chua co thong tin");
        }
        else {
        Users users=new Users();
        users.setAddress(userRegistrationDto.getAddress());
        users.setEmail(userRegistrationDto.getEmail());
        users.setCreateat(new Date());
        users.setIsactive(1);
        users.setName(userRegistrationDto.getName());
        users.setPassword(userRegistrationDto.getPassword());
        users.setPhone(userRegistrationDto.getPhone());
        users.setRole("ROLE_USER");
        return users;
        }
    }
}
