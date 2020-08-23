package com.tiremanagement.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiremanagement.orders.model.OrderDetails;
import com.tiremanagement.orders.model.Orders;


public interface OrderDetailsRepo extends JpaRepository<OrderDetails, Long> {
}
