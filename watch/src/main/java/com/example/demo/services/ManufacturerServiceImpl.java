package com.example.demo.services;


import com.example.demo.entity.Manufacturer;
import com.example.demo.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManufacturerServiceImpl implements ManufacturerService{
    @Autowired
    private ManufacturerRepository manufacturerRepository;
    @Override
    public List<Manufacturer> listManufacturers() {
        return manufacturerRepository.findAll();
    }

}
