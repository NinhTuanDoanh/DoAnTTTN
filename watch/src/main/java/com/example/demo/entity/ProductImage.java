package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name="product_image")
@Entity
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageid;
    @Column(name="url")
    private String url;
    @Column(name="isactive")
    private int isactive;
    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "product_image")
    private Products products;

}
