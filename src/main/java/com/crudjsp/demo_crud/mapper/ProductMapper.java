package com.crudjsp.demo_crud.mapper;

import com.crudjsp.demo_crud.dto.ProductDto;
import com.crudjsp.demo_crud.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {
    public ProductDto mapToDto(Product product) {
        ProductDto dto = new ProductDto();
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setDescription(product.getDescription());
        return dto;
    }
    public List<ProductDto> mapToDtoList(List<Product> products) {
        return products.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }
    public Product mapToEntity(ProductDto productDto) {
        Product entity = new Product();
        entity.setName(productDto.getName());
        entity.setPrice(productDto.getPrice());
        entity.setDescription(productDto.getDescription());
        return entity;
    }
}