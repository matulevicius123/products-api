package com.matulevicius123.products_api.service;

import com.matulevicius123.products_api.domain.model.Product;

public interface ProductService {
    Product findById(Long id);
    Product findByName(String name);
    Product create(Product product);
}
