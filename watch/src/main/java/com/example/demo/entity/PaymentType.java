package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name="paymenttype")
@Entity
public class PaymentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentid;
    @Column(name="name")
    private String name;
}
