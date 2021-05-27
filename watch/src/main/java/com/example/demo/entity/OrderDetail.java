package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name="orderdetail")
@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrderDetail;
    @Column(name="quantity")
    private int quantity;
    @Column(name="price")
    private int price;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "product_orderdetail")
    private Products products;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="product_order")
    private Order order;
}
