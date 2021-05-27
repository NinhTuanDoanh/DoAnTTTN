package com.example.demo.services;

import com.example.demo.Model.dto.OrderDto;
import com.example.demo.Model.mapper.OrderDetailMapper;
import com.example.demo.Model.mapper.OrderMapper;
import com.example.demo.repository.OrderDetailRepository;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckoutService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    public String saveOrder(OrderDto orderDto) throws Exception {
        orderRepository.save(OrderMapper.toOrderDto(orderDto));
        //orderDetailRepository.save(OrderDetailMapper.toOrderDto(orderDto));
        return "redirect:/";
    }
}
