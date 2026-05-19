package org.example.productsbackend.services;

import org.example.productsbackend.domain.dto.request.product.CreateProductRequest;
import org.example.productsbackend.domain.dto.response.product.ProductResponse;
import org.example.productsbackend.domain.entities.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    ProductResponse createProduct(CreateProductRequest product);
    List<Product> getAllProducts();
    Product getProductById(UUID id);
    void updateProduct(UUID id, Product product);
    Product deleteProduct(UUID id);
}
