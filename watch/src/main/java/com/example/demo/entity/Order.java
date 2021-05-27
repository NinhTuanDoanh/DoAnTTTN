package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="orders")
public class Order {
    @Id
    @Column(name="idorder")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrder;
    @Column(name="create_at")
    private Date createAt;
    @Column(name="receiver_name")
    private String receiverName;
    @Column(name="receiver_email")
    private String receiverEmail;
    @Column(name="receiver_address")
    private String receiverAddress;
    @Column(name="receiver_phone")
    private String receiverPhone;
    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetailList;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "users_order")
    private Users users;
}
