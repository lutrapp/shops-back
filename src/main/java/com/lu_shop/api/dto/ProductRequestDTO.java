package com.lu_shop.api.dto;

public record ProductRequestDTO(String name, String description, Double price, Integer stockQuantity, String category, String imageUrl) {}


