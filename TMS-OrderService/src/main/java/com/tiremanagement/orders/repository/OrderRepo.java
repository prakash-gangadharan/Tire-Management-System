package com.tiremanagement.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiremanagement.orders.model.Orders;


public interface OrderRepo extends JpaRepository<Orders, Long> {
}
