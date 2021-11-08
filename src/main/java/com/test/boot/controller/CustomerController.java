package com.test.boot.controller;

import com.test.boot.models.Customer;
import com.test.boot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/customer")
    public ResponseEntity<?> create(@RequestBody Customer customer){

        return new ResponseEntity(customerService.create(customer), HttpStatus.OK);
    }
    @GetMapping("/customer/custom")
    public ResponseEntity<?> findAllCustom(){
        return new ResponseEntity(customerService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/customer")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity(customerService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/customer/{id}")
    public ResponseEntity<?> findAll(@PathVariable Long id){
        return new ResponseEntity(customerService.findAll(id), HttpStatus.OK);
    }
    @GetMapping("/products")
    public ResponseEntity<?> findAllProd(){
        return new ResponseEntity(customerService.findAllProducts(), HttpStatus.OK);
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<?> findProductsById(@PathVariable Long id){
        return new ResponseEntity(customerService.findAllProducts(id), HttpStatus.OK);
    }
}
