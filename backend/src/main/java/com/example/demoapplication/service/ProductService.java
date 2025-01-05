package com.example.demoapplication.service;

import com.example.demoapplication.dto.user.ProductDto;
import com.example.demoapplication.dto.user.ApiResponseDto;
import com.example.demoapplication.exceptions.CustomException;
import com.example.demoapplication.model.Product;
import com.example.demoapplication.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    Logger logger = LoggerFactory.getLogger(ProductService.class);

    public ApiResponseDto addProduct(ProductDto productDto) throws CustomException{
        Product product = new Product(productDto.getTitle(), productDto.getDescription(), productDto.getPrice(), productDto.getImage());
        try {
            productRepository.save(product);
            logger.info("Product " + product.getTitle() + " added successfully");
            return new ApiResponseDto("success", "product added successfully");
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }
    }

    public Integer getProductCount() throws CustomException {
        try{
            return productRepository.findAll().size();
        }
        catch (Exception e){
            throw new CustomException("No products found");
        }
    }

    public List<Product> getAllProducts() throws CustomException {
        try{
            return productRepository.findAll();
        }
        catch (Exception e){
            throw new CustomException("No products found");
        }
    }

    public Optional<Product> getProductByName(String name) throws CustomException{
        try{
            return productRepository.findByTitle(name);
        }
        catch (Exception e){
            throw new CustomException("Failed to find product that you are looking for");
        }
    }

    public Optional<Product> getProductById(Integer productId) throws CustomException{
        try{
            return productRepository.findById(productId);
        }
        catch (Exception e){
            throw new CustomException("Failed to find product that you are looking for");
        }
    }

    public Integer deleteProductByName(String title) throws CustomException{
        try{
            Optional<Product> p = productRepository.findByTitle(title);
            productRepository.deleteById(p.get().getProductId());
            return p.get().getProductId();
        }
        catch (Exception e){
            throw new CustomException("Failed to delete");
        }
    }
}
