package com.example.demoapplication.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private Integer productId;
    private String image;
    private String description;
    private Integer price;
    private String title;
}
