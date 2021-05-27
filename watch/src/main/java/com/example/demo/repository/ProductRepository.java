package com.example.demo.repository;

import com.example.demo.entity.Products;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products,Long>{
    List<Products> findAllByManufacturer(Long id);
}
