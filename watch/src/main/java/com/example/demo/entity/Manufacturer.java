package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name="manufacturer")
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idmanufacturer;
    @Column(name="name")
    private String name;
    @Column(name="isactive")
    private int isActive;
    @OneToMany(mappedBy = "manufacturer")
    private List<Products> productsList;
}
