package com.example.demo.services;

import com.example.demo.entity.Manufacturer;
import com.example.demo.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {
    @Autowired
    private ManufacturerRepository manufacturerRepository;

    public List<Manufacturer> listManufacturer()
    {
        return manufacturerRepository.findAll();
    }
    public void deleteBrandById(Long id)
    {
        manufacturerRepository.deleteById(id);
    }
}
