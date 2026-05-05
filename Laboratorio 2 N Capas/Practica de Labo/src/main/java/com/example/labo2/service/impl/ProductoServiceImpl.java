package com.example.labo2.service.impl;

import com.example.labo2.domain.entity.Product;
import com.example.labo2.repository.ProductRepository;
import com.example.labo2.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public void createProduct (Product producto){
        productRepository.save(producto);

    }
}
