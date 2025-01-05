package com.example.demoapplication.dto.user;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CartDto {
    private Integer cartId;
    private Integer productId;
    private Integer userId;
    private Integer quantity;
    private Integer subTotal;
}
