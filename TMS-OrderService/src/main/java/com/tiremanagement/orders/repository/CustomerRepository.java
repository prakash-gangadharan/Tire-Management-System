package com.tiremanagement.orders.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tiremanagement.orders.dto.OrderResponse;
import com.tiremanagement.orders.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

	@Query("SELECT new com.tiremanagement.orders.dto.OrderResponse(c.id, c.name , p.productName, p.qty, p.price) FROM Customer c JOIN c.products p")
	public List<OrderResponse> getJoinInformation();
}
