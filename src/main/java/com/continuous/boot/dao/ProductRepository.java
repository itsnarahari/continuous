package com.continuous.boot.dao;

import com.continuous.boot.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Long> {
//    public Products findProductsByCustomer(Long id);
}
