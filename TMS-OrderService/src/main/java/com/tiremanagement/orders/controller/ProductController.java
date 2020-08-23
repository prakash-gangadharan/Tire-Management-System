package com.tiremanagement.orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tiremanagement.orders.model.Orders;
import com.tiremanagement.orders.model.Product;
import com.tiremanagement.orders.repository.ProductRepo;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductRepo productRepo;

    @GetMapping
    ResponseEntity<List<Product>> getOrders(){
        return new ResponseEntity<List<Product>>((List<Product>) productRepo.findAll(), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Product> saveOrder(@RequestBody Product product){
        return new ResponseEntity<Product>(productRepo.save(product), HttpStatus.OK);
    }
}
