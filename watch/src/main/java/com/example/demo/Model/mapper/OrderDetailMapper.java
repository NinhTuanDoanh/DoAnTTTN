package com.example.demo.Model.mapper;

import com.example.demo.Model.dto.OrderDto;
import com.example.demo.entity.OrderDetail;
import org.springframework.util.ObjectUtils;

public class OrderDetailMapper {
    public static OrderDetail toOrderDto(OrderDto orderDto) throws Exception{
        if(ObjectUtils.isEmpty(orderDto)){
            throw new Exception("Chua co thong tin");
        }
        else {
            OrderDetail orderDetail=new OrderDetail();
            orderDetail.setPrice(orderDto.getPrice());
            orderDetail.setQuantity(orderDto.getQuantity());
            return orderDetail;
        }
    }
}
