package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Table(name="categories")
@Entity
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcategories;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String descrition;
    @Column(name="create_at")
    private LocalDateTime createat;
    @Column(name="update_at")
    private LocalDateTime updateat;
    @Column(name="status")
    private int status;
    @OneToMany(mappedBy = "categories", cascade = CascadeType.ALL)
    private List<ProductCategory> productCategoryList;

}
