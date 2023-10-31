package com.crudjsp.demo_crud.service;

import com.crudjsp.demo_crud.dto.ApiResponse;
import com.crudjsp.demo_crud.dto.ProductDto;
import com.crudjsp.demo_crud.entity.Product;
import com.crudjsp.demo_crud.errorss.InvalidProductException;
import com.crudjsp.demo_crud.mapper.ProductMapper;
import com.crudjsp.demo_crud.repoistory.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ApiResponse saveProduct(ProductDto productDto) {
        // Validate the DTO before mapping to an entity
        if (isValidProductDto(productDto)) {
            Product product = productMapper.mapToEntity(productDto);
            // Save the product entity to the database
            Product savedProduct = productRepository.save(product);
            return new ApiResponse(HttpStatus.CREATED.value(), "Product created successfully", savedProduct);
        } else {
            return new ApiResponse(HttpStatus.BAD_REQUEST.value(), "Invalid Product DTO", null);
        }
    }

    public ApiResponse updateProduct(Long id, ProductDto productDto) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct != null) {
            // Validate the DTO before mapping to an entity
            if (isValidProductDto(productDto)) {
                Product updatedProduct = productMapper.mapToEntity(productDto);
                updatedProduct.setId(id);
                // Save the updated product entity to the database
                Product savedProduct = productRepository.save(updatedProduct);
                return new ApiResponse(HttpStatus.OK.value(), "Product updated successfully", savedProduct);
            } else {
                return new ApiResponse(HttpStatus.BAD_REQUEST.value(), "Invalid Product DTO", null);
            }
        } else {
            return new ApiResponse(HttpStatus.NOT_FOUND.value(), "Product not found", null);
        }
    }

    public ApiResponse getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = productMapper.mapToDtoList(products);
        return new ApiResponse(HttpStatus.OK.value(), "Product list retrieved successfully", productDtos);
    }

    public ApiResponse deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return new ApiResponse(HttpStatus.NO_CONTENT.value(), "Product deleted successfully", null);
        } else {
            return new ApiResponse(HttpStatus.NOT_FOUND.value(), "Product not found", null);
        }
    }

    public ApiResponse getProductById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            ProductDto productDto = productMapper.mapToDto(product);
            return new ApiResponse(HttpStatus.OK.value(), "Product retrieved successfully", productDto);
        } else {
            return new ApiResponse(HttpStatus.NOT_FOUND.value(), "Product not found", null);
        }
    }

    private boolean isValidProductDto(ProductDto productDto) {
        return productDto != null
                && isNotBlank(productDto.getName())
                && productDto.getPrice() > 0
                && isDescriptionValid(productDto.getDescription());
    }

    private boolean isNotBlank(String value) {
        return value != null && !value.trim().isEmpty();
    }

    private boolean isDescriptionValid(String description) {
        return description == null || description.length() <= 200;
    }
}