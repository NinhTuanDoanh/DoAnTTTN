package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Table(name="product_category")
@Entity
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productCategoryId;
    @Column(name="create_at")
    private Date createat;
    @Column(name="update_at")
    private Date updateat;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "product_category")
    private Products product;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="product_categories")
    private Categories categories;
}
