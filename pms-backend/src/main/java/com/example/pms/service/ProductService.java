package com.example.pms.service;

import com.example.pms.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);
    ProductDto getProductById(Long id);
    List<ProductDto> getAllProducts();
    ProductDto updateProduct(Long id, ProductDto updateedProductDto);
    void deleteProductByID(Long id);
}
