package com.lu_shop.api.service;

import com.lu_shop.api.dto.ProductRequestDTO;
import com.lu_shop.api.dto.ProductResponseDTO;
import com.lu_shop.api.entity.Product;
import com.lu_shop.api.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponseDTO addProduct(ProductRequestDTO productRequestDTO) {
        if (productRepository.findByName(productRequestDTO.name()).isPresent()) {
            throw new RuntimeException("Produto já existe com este nome.");
        }

        Product product = new Product();
        product.setName(productRequestDTO.name());
        product.setDescription(productRequestDTO.description());
        product.setPrice(productRequestDTO.price());
        product.setStockQuantity(productRequestDTO.stockQuantity());
        product.setCategory(productRequestDTO.category());
        product.setImageUrl(productRequestDTO.imageUrl());

        Product savedProduct = productRepository.save(product);

        return new ProductResponseDTO(
                savedProduct.getId(),
                savedProduct.getName(),
                savedProduct.getDescription(),
                savedProduct.getPrice(),
                savedProduct.getStockQuantity(),
                savedProduct.getCategory(),
                savedProduct.getImageUrl()
        );
    }
}
