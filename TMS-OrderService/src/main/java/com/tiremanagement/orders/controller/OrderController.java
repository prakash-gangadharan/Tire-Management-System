package com.tiremanagement.orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tiremanagement.orders.model.OrderDetails;
import com.tiremanagement.orders.model.Orders;
import com.tiremanagement.orders.model.Product;
import com.tiremanagement.orders.repository.OrderDetailsRepo;
import com.tiremanagement.orders.repository.OrderRepo;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    OrderRepo orderRepo;
    
    @Autowired
    OrderDetailsRepo orderDetailsRepo;

    @GetMapping
    ResponseEntity<List<Orders>> getOrders(){
        return new ResponseEntity<List<Orders>>((List<Orders>) orderRepo.findAll(), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Orders> saveOrder(@RequestBody Orders orders){
        return new ResponseEntity<Orders>(orderRepo.save(orders), HttpStatus.OK);
    }

    @PostMapping("/orderDetails")
    ResponseEntity<OrderDetails> saveOrderDetails(@RequestBody OrderDetails OrderDetail){
    	
        return new ResponseEntity<OrderDetails>(orderDetailsRepo.save(OrderDetail), HttpStatus.OK);
    }
    
}
