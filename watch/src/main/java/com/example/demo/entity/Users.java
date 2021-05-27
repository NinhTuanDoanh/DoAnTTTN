package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="users_id",unique = true)
    private Long userid;
    @Column(name="user_name")
    private String name;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="create_at")
    private Date createat;
    @Column(name="update_at")
    private Date updateat;
    @Column(name="phone")
    private String phone;
    @Column(name="adress")
    private String address;
    @Column(name="role")
    private String role;
    @Column(name="is_active")
    private int isactive;
    @Column(name="paymentype")
    private int paymenttype;
    @OneToMany(mappedBy = "users")
    private List<Order> orderList;
    @OneToMany(mappedBy = "users")
    private List<Comment> commentList;
    @OneToOne
    @JoinColumn(name="payment_type")
    private PaymentType paymentType;
}
