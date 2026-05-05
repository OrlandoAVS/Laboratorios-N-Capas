package com.example.labo2.controller;

import com.example.labo2.domain.entity.Product;
import com.example.labo2.service.ProductService;
import com.example.labo2.service.impl.ProductoServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/product")
@AllArgsConstructor

public class ProductController {
    private final ProductoServiceImpl productoService;
    private final ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        productService.createProduct(product);
        return  ResponseEntity.status(HttpStatus.CREATED)
                .body(product);
    }
}
