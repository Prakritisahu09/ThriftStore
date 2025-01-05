package com.example.demoapplication.repository;

import com.example.demoapplication.model.Product;
import com.example.demoapplication.model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findByTitle(String title);

    @Override
    List<Product> findAll();

    Optional<Product> findByProductId(Integer productId);
}
