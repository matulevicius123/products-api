package com.matulevicius123.products_api.domain.repository;

import com.matulevicius123.products_api.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

    
} 
