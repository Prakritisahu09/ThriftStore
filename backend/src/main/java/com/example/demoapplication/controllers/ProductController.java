package com.example.demoapplication.controllers;

import com.example.demoapplication.dto.user.ProductDto;
import com.example.demoapplication.dto.user.ApiResponseDto;
import com.example.demoapplication.exceptions.CustomException;
import com.example.demoapplication.model.Product;
import com.example.demoapplication.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @PostMapping("/add")
    public ApiResponseDto addProduct(@RequestBody ProductDto productDto) throws CustomException {
        logger.info(productDto.toString());
        try{
            return productService.addProduct(productDto);
        }
        catch(CustomException ce){
            logger.error(ce.getMessage());
            return new ApiResponseDto("failed", "failed to add product");
        }
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() throws CustomException {
        try {
            return productService.getAllProducts();
        } catch (CustomException e) {
            throw e;
        }
    }

    @GetMapping("/count")
    public Integer getProductCount() throws CustomException {
        try {
            return productService.getProductCount();
        } catch (CustomException e) {
            throw e;
        }
    }

//    @GetMapping ("{name}")
//    public Optional<Product> getProduct(@PathVariable String name) throws CustomException {
//        try {
//            return productService.getProductByName(name);
//        } catch (CustomException e) {
//            throw e;
//        }
//    }

    @GetMapping("/{productId}")
    public Optional<Product> getProduct(@PathVariable Integer productId) throws CustomException {
        try {
            return productService.getProductById(productId);
        } catch (CustomException e) {
            throw e;
        }
    }

    @DeleteMapping("/{title}")
    public ApiResponseDto deleteProduct(@PathVariable String title) throws CustomException {
        try {
            productService.deleteProductByName(title);
            return new ApiResponseDto("success", "Product deleted successfully");
        } catch (CustomException e) {
            logger.error(e.getMessage());
            return new ApiResponseDto("failed", "failed to delete product");
        }
    }
}
