package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@Table(name="products")
@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private Long productid;
    @Column(name="product_name")
    private String productname;
    @Column(name="price")
    private int price;
    @Column(name="description")
    private String description;
    @Column(name="create_at")
    private Date createat;
    @Column(name="update_at")
    private Date updateat;
    @Column(name="is_active")
    private int isactive;
    @Column(name="sale")
    private int sale;
    @Column(name="quantity")
    private int quantity;
    @Column(name = "product_manufacturer")
    private Long manufacturer;
//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "product_manufacturer")
//    private Manufacturer manufacturer;
    @OneToMany(mappedBy = "product")
    private List<ProductCategory> productCategoryCollection;
    @OneToMany(mappedBy = "products",fetch = FetchType.EAGER)
    private List<ProductImage> productImageList;
    @OneToMany(mappedBy = "products")
    private List<OrderDetail> orderDetails;
    @OneToMany(mappedBy = "products")
    private List<Comment> commentList;

}
