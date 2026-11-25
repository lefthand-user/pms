package com.example.pms.service.impl;

import com.example.pms.dto.ProductDto;
import com.example.pms.entity.Product;
import com.example.pms.exceptions.ResourceNotFoundException;
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

    @Override
    public ProductDto getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Product does not exist with id:" + id
                ));

        return ProductMapper.mapToProductDto(product);


    }

}
