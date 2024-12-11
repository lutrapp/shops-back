package com.lu_shop.api.dto;

import java.math.BigDecimal;

public record ProductResponseDTO(Long id, String name, String description, BigDecimal price, Integer stockQuantity, String category, String imageUrl) {}


