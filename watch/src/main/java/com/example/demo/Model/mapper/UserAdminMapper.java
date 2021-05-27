package com.example.demo.Model.mapper;


import com.example.demo.Model.dto.UserDto;
import com.example.demo.entity.Users;
import org.springframework.util.ObjectUtils;
import java.util.Date;

public class UserAdminMapper {
    public static Users toUserDto(UserDto userDto) throws Exception {

        if(ObjectUtils.isEmpty(userDto)){
            throw new Exception("Chua co thong tin");
        }
        else {
            Users users=new Users();
            users.setAddress(userDto.getAddress());
            users.setEmail(userDto.getEmail());
            users.setCreateat(new Date());
            users.setIsactive(1);
            users.setName(userDto.getName());
            users.setPassword(userDto.getPassword());
            users.setPhone(userDto.getPhone());
            users.setRole(userDto.getRole());
            return users;
        }
    }
}
