package com.continuous.boot.controller;

import com.continuous.boot.dao.ProductRepository;
import com.continuous.boot.models.Customer;
import com.continuous.boot.models.Products;
import com.continuous.boot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    public ResponseEntity<?> findAllProducts() {
        return new ResponseEntity(productRepository.findAll(Sort.by("productName").descending()), HttpStatus.OK);
    }

    @RequestMapping(path = "/download", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> download() throws IOException {
        String fileName = "first.txt";
        PrintWriter writer = new PrintWriter(fileName, "UTF-8");
        writer.println("The first line");
        writer.println("The second line");
        writer.close();

        File file = new File(fileName);

        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment; filename=%s", fileName));
        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
        header.add("Pragma", "no-cache");
        header.add("Expires", "0");
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        return ResponseEntity.ok()
                .headers(header)
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

    @PostMapping("/customer")
    public ResponseEntity<?> create(@RequestBody Customer customer) {
        List<Products> productsList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Products products = new Products();
            products.setProductName("product" + i);
            productsList.add(products);
        }
        customer.setProducts(productsList);
        return new ResponseEntity(customerService.create(customer), HttpStatus.OK);
    }

    @GetMapping("/customer/custom")
    public ResponseEntity<?> findAllCustom() {
        return new ResponseEntity(customerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/customer")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity(customerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<?> findAll(@PathVariable Long id) {
        return new ResponseEntity(customerService.findAll(id), HttpStatus.OK);
    }

    //    @GetMapping("/products")
//    public ResponseEntity<?> findAllProd(){
//        return new ResponseEntity(customerService.findAllProducts(), HttpStatus.OK);
//    }
    @GetMapping("/products/{id}")
    public ResponseEntity<?> findProductsById(@PathVariable Long id) {
        return new ResponseEntity(customerService.findAllProducts(id), HttpStatus.OK);
    }
}
