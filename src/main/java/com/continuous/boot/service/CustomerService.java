package com.continuous.boot.service;

import com.continuous.boot.dao.CustomerRepository;
import com.continuous.boot.dao.ProductRepository;
import com.continuous.boot.models.Customer;
import com.continuous.boot.models.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;


    public Customer create(Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findAll(Long id) {
        return customerRepository.findById(id).get();
    }

    public List<Products> findAllProducts() {
        return productRepository.findAll();
    }

    public Products findAllProducts(Long id) {
        return null;
    }

    public List<Customer> findAllCustom() {
        return customerRepository.findAllCustom();
    }
}
