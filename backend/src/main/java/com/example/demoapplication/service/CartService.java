package com.example.demoapplication.service;

import com.example.demoapplication.dto.user.ApiResponseDto;
import com.example.demoapplication.dto.user.CartDto;
import com.example.demoapplication.exceptions.CustomException;
import com.example.demoapplication.model.Cart;
import com.example.demoapplication.model.Product;
import com.example.demoapplication.repository.CartRepository;
import com.example.demoapplication.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductService productService;

    Logger logger = LoggerFactory.getLogger(CartService.class);

    public ApiResponseDto addToCart(CartDto cartDto) throws CustomException {
        Optional<Product> product = productService.getProductById(cartDto.getProductId());
        Integer subtotal = cartDto.getQuantity() * product.get().getPrice();

        Cart cartItem = new Cart(cartDto.getProductId(), cartDto.getUserId(), cartDto.getQuantity(), subtotal);
        try {
            cartRepository.save(cartItem);
            logger.info(product.get().getTitle() + " added successfully to the cart");
            return new ApiResponseDto("success", "product added successfully to the cart");
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }
    }

    public List<Cart> getCart(Integer userId) throws CustomException {
        try{
            return cartRepository.findByUserId(userId);
        }
        catch (Exception e){
            throw new CustomException("Failed to find product that you are looking for");
        }
    }

//    public ApiResponseDto deleteProductByProductIdAndUserId(Integer productId, Integer userId) throws CustomException{
//        try{
////            Optional<Cart> c = cartRepository.findByProductIdAndUserId(productId, userId);
//            cartRepository.deleteByProductIdAndUserId(productId, userId);
//            return new ApiResponseDto("success", "product deleted from the cart successfully");
//        }
//        catch (Exception e){
//            throw new CustomException("Failed to delete");
//        }
//    }

    public ApiResponseDto deleteById(Integer cartID) throws CustomException{
        try{
//            Optional<Cart> c = cartRepository.findByProductIdAndUserId(productId, userId);
            cartRepository.deleteById(cartID);
            return new ApiResponseDto("success", "product deleted from the cart successfully");
        }
        catch (Exception e){
            throw new CustomException("Failed to delete");
        }
    }

//    public ApiResponseDto deleteProductByProductIdAndUserId(Integer productId, Integer  cartId) throws CustomException{
//        try{
////            Optional<Cart> c = cartRepository.findByProductIdAndUserId(productId, userId);
//            Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new CustomException("Cart not found"));
//
//            Product item = ProductRepository.findById(productId).orElseThrow(() -> new CustomException("Item not found with ID"));
//
//            cartRepository.dele(productId, cartId);
//            return new ApiResponseDto("success", "product deleted from the cart successfully");
//        }
//        catch (Exception e){
//            throw new CustomException("Failed to delete");
//        }
//    }



    public ApiResponseDto updateCart(CartDto cartDto) throws CustomException {
        Optional<Product> product = productService.getProductById(cartDto.getProductId());
        Integer subtotal = cartDto.getQuantity() * product.get().getPrice();

        Cart cartItem = new Cart(cartDto.getCartId(),cartDto.getProductId(), cartDto.getUserId(), cartDto.getQuantity(),subtotal);
        try {
            cartRepository.save(cartItem);
            logger.info(product.get().getTitle() + " updated successfully in the cart");
            return new ApiResponseDto("success", "updated successfully in the cart");
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }

    }
}
