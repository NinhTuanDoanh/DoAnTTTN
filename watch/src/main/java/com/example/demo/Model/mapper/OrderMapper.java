package com.example.demo.Model.mapper;

import com.example.demo.Model.dto.OrderDto;
import com.example.demo.Model.dto.ProductsDto;
import com.example.demo.entity.Order;
import com.example.demo.entity.Products;
import org.springframework.util.ObjectUtils;

import java.util.Date;

public class OrderMapper {
        public static Order toOrderDto(OrderDto orderDto) throws Exception{
            if(ObjectUtils.isEmpty(orderDto)){
                throw new Exception("Chua co thong tin");
            }
            else {
                Order order=new Order();
                order.setReceiverAddress(orderDto.getReceiver_address());
                order.setReceiverEmail(orderDto.getReceiver_email());
                order.setReceiverName(orderDto.getReceiver_name());
                order.setReceiverPhone(orderDto.getReceiver_phone());
                order.setCreateAt(new Date());
                return order;
            }
        }

}
