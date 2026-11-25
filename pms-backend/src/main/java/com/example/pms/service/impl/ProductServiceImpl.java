package com.example.pms.service.impl;

import com.example.pms.dto.ProductDto;
import com.example.pms.entity.Product;
import com.example.pms.mapper.ProductMapper;
import com.example.pms.repository.ProductRepository;
import com.example.pms.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = ProductMapper.mapToProduct(productDto);
        Product savedProduct = productRepository.save(product);
        return ProductMapper.mapToProductDto(savedProduct);
    }
}
