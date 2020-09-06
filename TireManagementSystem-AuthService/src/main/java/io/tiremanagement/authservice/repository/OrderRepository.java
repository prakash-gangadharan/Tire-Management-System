package io.tiremanagement.authservice.repository;


import java.util.Map;

import io.tiremanagement.authservice.entity.Order;

public interface OrderRepository {

	void save(Order customer);
	Order find(Long id);
	Map<Long, Order> findAll();
}
