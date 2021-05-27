package com.example.demo.repository;

import com.example.demo.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage,Long> {
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM product_image where product_image=?1",nativeQuery = true)
    void deleteProductImageByImageid(Long product_image);
}
