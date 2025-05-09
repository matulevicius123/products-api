package com.matulevicius123.products_api.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.matulevicius123.products_api.domain.model.Product;
import com.matulevicius123.products_api.domain.repository.ProductRepository;
import com.matulevicius123.products_api.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
    
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product findById(Long id) { 
        
        return productRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Product findByName(String name) {
        if (!productRepository.existsByName(name)) {
            throw new NoSuchElementException("Product with name " + name + " not found");
        }

        return productRepository.findByName(name).stream().findFirst()  
        .orElseThrow(() -> new NoSuchElementException("Product with name " + name + " not found"));
        }

    @Override
    public Product create(Product newProduct) {
        if (newProduct.getId() != null && productRepository.existsById(newProduct.getId())) {
            throw new IllegalArgumentException("This Product ID already exists.");
        }
        
        return productRepository.save(newProduct);
    }
}
