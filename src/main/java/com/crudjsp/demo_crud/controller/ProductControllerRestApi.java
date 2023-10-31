package com.crudjsp.demo_crud.controller;

import com.crudjsp.demo_crud.dto.ApiResponse;
import com.crudjsp.demo_crud.dto.ProductDto;
import com.crudjsp.demo_crud.entity.Product;
import com.crudjsp.demo_crud.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/product")
@RestController
public class ProductControllerRestApi {

    private final ProductService productService;

    public ProductControllerRestApi(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createProduct(@RequestBody ProductDto productDto) {
        ApiResponse response = productService.saveProduct(productDto);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        ApiResponse response = productService.updateProduct(id, productDto);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllProducts() {
        ApiResponse response = productService.getAllProducts();
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Long id) {
        ApiResponse response = productService.deleteProduct(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getProductById(@PathVariable Long id){
        ApiResponse response = productService.getProductById(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
