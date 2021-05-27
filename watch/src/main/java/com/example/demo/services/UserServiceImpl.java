package com.example.demo.services;


import com.example.demo.Model.dto.UserDto;
import com.example.demo.Model.mapper.ProductMapper;
import com.example.demo.Model.mapper.UserAdminMapper;
import com.example.demo.entity.Products;
import com.example.demo.entity.Users;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<Users> getListUser() {
        return userRepository.findAll();
    }

    @Override
    public String addUserByAdmin(UserDto userDto) {
        String result = "addaccount";
        String error = null;
        Products product = null;
        System.out.println(userDto);
        try {
            Users users = UserAdminMapper.toUserDto(userDto);
            // save product to db
            users = userRepository.save(users);
            result = "redirect:/usermanager";
        } catch (Exception e) {

        }
        return result;
    }

    @Override
    public void deleteAccountById(Long id) {
        userRepository.deleteById(id);
    }


}
