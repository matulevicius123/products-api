package com.matulevicius123.products_api.controller;

import com.matulevicius123.products_api.domain.model.Product;
import com.matulevicius123.products_api.service.ProductService;

import io.swagger.v3.oas.annotations.Parameter;

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
    @Parameter(description = "ID of the product", example = "123", required = true)
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        var product = productService.findById(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/name/{name}")
    @Parameter(description = "Name of the product", example = "Hairbrush", required = true)
    public ResponseEntity<Product> findByName(@PathVariable String name) {
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
}
