package com.matulevicius123.products_api.domain.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "tb_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    private Long id;
    
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String seller;

    @Column(nullable = false, scale = 2)
    private float price;

    @Column(nullable = false)
    private int stock;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private float Rating;
    
    @OneToMany(cascade = CascadeType.ALL)
    private final List<Review> reviews = new ArrayList<>();

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSeller() {
        return seller;
    }
    public void setSeller(String seller) {
        this.seller = seller;
    }

    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public float getRating() {
        return Rating;
    }
    public void setRating(float rating) {
        Rating = rating;
    }

    public List<Review> getReviews() {
        return Collections.unmodifiableList(reviews);
    }
}
