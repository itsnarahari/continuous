package com.test.boot.dao;

import com.test.boot.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Long> {
    public Products findProductsByCustomer(Long id);
}
