package com.matulevicius123.products_api.controller;

import com.matulevicius123.products_api.domain.model.Product;
import com.matulevicius123.products_api.domain.model.Review;
import com.matulevicius123.products_api.service.ProductService;

import jakarta.transaction.Transactional;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") Long id) {
        var product = productService.findById(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Product> findByName(@PathVariable("name") String name) {
        var product = productService.findByName(name);
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product newProduct) {
        var productCreated = productService.create(newProduct);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(productCreated.getId())
            .toUri();
        return ResponseEntity.created(location).body(productCreated);
    }

    @PostMapping("/{id}/reviews")
    @Transactional
    public ResponseEntity<Product> addReview(@PathVariable("id") Long id, @RequestBody Review review) {
        productService.addReviewToProduct(id, review);
        return ResponseEntity.noContent().build();
    }
}
