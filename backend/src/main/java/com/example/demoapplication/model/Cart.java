package com.example.demoapplication.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartId;
    private Integer productId;
    private Integer userId;
    private Integer quantity;
    private Integer subTotal;

    public Cart(Integer productId, Integer userId, Integer quantity, Integer subTotal) {
        this.productId = productId;
        this.userId = userId;
        this.quantity = quantity;
        this.subTotal = subTotal;
    }

    public Cart() {
    }

    public Cart(Integer cartId, Integer productId, Integer userId, Integer quantity, Integer subTotal) {
        this.cartId = cartId;
        this.productId = productId;
        this.userId = userId;
        this.quantity = quantity;
        this.subTotal = subTotal;
    }
}
