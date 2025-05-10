package com.matulevicius123.products_api.service;

import com.matulevicius123.products_api.domain.model.Product;
import com.matulevicius123.products_api.domain.model.Review;

public interface ProductService {
    Product findById(Long id);
    Product findByName(String name);
    Product create(Product product);
    public Product addReviewToProduct(Long productId, Review review);
}
