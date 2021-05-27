package com.example.demo.services;


import com.example.demo.Model.dto.UserRegistrationDto;
import com.example.demo.Model.mapper.UserMapper;
import com.example.demo.entity.Users;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class RegisterServiceImpl implements RegisterService{
    //
    @Autowired
    private UserRepository userRepository;

    @Override
    public Boolean registerUser(UserRegistrationDto userRegistrationDto) {
        // tim user co email da ton tai chua trong bang user
        UserMapper userMapper = new UserMapper();
        Users users = userRepository.findByEmail(userRegistrationDto.getEmail());
        try
        {
            if(!ObjectUtils.isEmpty(users))
            {
                throw new Exception("Email da ton tai ");
            }
            userRepository.save(userMapper.toUserDto(userRegistrationDto));
            return true;
        } catch (Exception e) {
            return  false;
        }
    }
}
