package com.example.demoapplication.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    @Column(name = "image")
    private String image;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Integer price;
    @Column(name = "title")
    private String title;

    public Product(){

    }

    public Product(String title, String description, Integer price, String imgUrl) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.image = imgUrl;

    }
}
