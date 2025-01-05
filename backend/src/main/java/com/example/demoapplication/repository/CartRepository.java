package com.example.demoapplication.repository;

import com.example.demoapplication.model.Cart;
import com.example.demoapplication.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findByUserId(Integer userId);

    Optional<Cart> findByProductIdAndUserId(Integer productId, Integer userId);

    void deleteByProductIdAndUserId(Integer productId, Integer userId);
}
