package com.example.demo.services;

import com.example.demo.Model.dto.UserLoginDto;
import com.example.demo.entity.Users;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class LoginServiceImpl implements LoginService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public Boolean loginService(UserLoginDto userLoginDto){
        Users user = userRepository.findByEmail(userLoginDto.getEmail());
        try{
            if (ObjectUtils.isEmpty(user)) {
                throw new Exception("Tai khoan,mat khau khong ton tai");
            } else if (user.getEmail().equals(userLoginDto.getEmail())
                    && user.getPassword().equals(userLoginDto.getPassword())){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            return false;
        }

    }
}
