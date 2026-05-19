package org.example.productsbackend.common.mappers;

import org.example.productsbackend.domain.dto.request.product.CreateProductRequest;
import org.example.productsbackend.domain.dto.response.product.ProductResponse;
import org.example.productsbackend.domain.entities.Product;
import org.example.productsbackend.repositories.ProductRepository;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    private final ProductRepository productRepository;

    public ProductMapper(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product toEntityCreate(CreateProductRequest product){
        return Product.builder()
                .name(product.getName())
                .category(product.getCategory())
                .price(product.getPrice())
                .available(product.getAvailable())
                .build();
    }
    public ProductResponse toDto(Product product){
        return ProductResponse.builder()
                .name(product.getName())
                .price(product.getPrice())
                .available(product.getAvailable())
                .build();
    }
}