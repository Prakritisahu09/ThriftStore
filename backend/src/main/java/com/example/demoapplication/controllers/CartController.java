package com.example.demoapplication.controllers;

import com.example.demoapplication.dto.user.ApiResponseDto;
import com.example.demoapplication.dto.user.CartDto;
import com.example.demoapplication.dto.user.ProductDto;
import com.example.demoapplication.exceptions.CustomException;
import com.example.demoapplication.model.Cart;
import com.example.demoapplication.model.Product;
import com.example.demoapplication.model.User;
import com.example.demoapplication.service.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    Logger logger = LoggerFactory.getLogger(CartController.class);

    @PostMapping("/add")
    public ApiResponseDto addToCart(@RequestBody CartDto cartDto) throws CustomException {
        try{
            return cartService.addToCart(cartDto);
        }
        catch(CustomException ce){
            return new ApiResponseDto("failed", "failed to add product");
        }
    }

    @GetMapping("/{userId}")
    public List<Cart> getCart(@PathVariable Integer userId) throws CustomException {
        try {
            return cartService.getCart(userId);
        } catch (CustomException e) {
            throw e;
        }
    }

//    @DeleteMapping("/{userId}/{productId}")
//    public ApiResponseDto deleteCartItem(@PathVariable("productId") Integer productId, @PathVariable("userId") Integer userId ) throws CustomException {
//        try {
//            return cartService.deleteProductByProductIdAndUserId(productId,userId);
//        } catch (CustomException e) {
//            e.printStackTrace();
//            return new ApiResponseDto("failed", "failed to delete cart item");
//        }
//    }

    @DeleteMapping("/{cartId}")
    public ApiResponseDto deleteCartItem(@PathVariable("cartId") Integer cartId) throws CustomException {
        try {
            return cartService.deleteById(cartId);
        }
        catch (CustomException e) {
            e.printStackTrace();
            return new ApiResponseDto("failed", "failed to delete cart item");
        }
    }

//    @DeleteMapping("/{cartId}/{productId}")
//    public ApiResponseDto deleteCartItem(@PathVariable("cartId") Integer cartId, @PathVariable("productId") Integer productId ) throws CustomException {
//        try {
//            return cartService.deleteProductByProductIdAndUserId(productId,cartId);
//        } catch (CustomException e) {
//            e.printStackTrace();
//            return new ApiResponseDto("failed", "failed to delete cart item");
//        }
//    }

        @PutMapping("/update")
    public ApiResponseDto updateCartItem(@RequestBody CartDto cartDto) throws CustomException {
        try {
            return cartService.updateCart(cartDto);
        } catch (CustomException e) {
            logger.error(e.getMessage());
            return new ApiResponseDto("failed", "failed to update cart");
        }
    }

}
