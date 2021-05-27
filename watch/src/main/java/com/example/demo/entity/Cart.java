package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cart {
    private Products product;
    private int quantity;

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
