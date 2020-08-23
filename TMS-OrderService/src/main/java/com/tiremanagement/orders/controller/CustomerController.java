package com.tiremanagement.orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tiremanagement.orders.model.Customer;
import com.tiremanagement.orders.repository.CustomerRepo;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    CustomerRepo customerRepo;


    @GetMapping
    ResponseEntity<List<Customer>> getCustomers(){
        return new ResponseEntity<List<Customer>>((List<Customer>) customerRepo.findAll(), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
        return new ResponseEntity<Customer>(customerRepo.save(customer), HttpStatus.OK);
    }


}
