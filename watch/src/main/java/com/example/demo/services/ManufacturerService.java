package com.example.demo.services;


import com.example.demo.entity.Manufacturer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ManufacturerService {
    List<Manufacturer> listManufacturers();
}
