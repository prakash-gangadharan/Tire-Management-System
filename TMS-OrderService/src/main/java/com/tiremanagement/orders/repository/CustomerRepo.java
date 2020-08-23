package com.tiremanagement.orders.repository;

import org.springframework.data.repository.CrudRepository;

import com.tiremanagement.orders.model.Customer;


public interface CustomerRepo extends CrudRepository<Customer, Long> {
}
