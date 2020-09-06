package io.tiremanagement.authservice.repository;


import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import io.tiremanagement.authservice.entity.Order;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

	private static final String KEY = "Customer";

	private RedisTemplate<String, Object> redisTemplate;
	private HashOperations<String, Long, Order> hashOperations;

	@Autowired
	public OrderRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@PostConstruct
	private void init() {
		hashOperations = redisTemplate.opsForHash();
	}

	@Override
	public void save(Order customer) {
		hashOperations.put(KEY, customer.getId(), customer);
	}

	@Override
	public Order find(Long id) {
		return hashOperations.get(KEY, id);
	}

	@Override
	public Map<Long, Order> findAll() {
		return hashOperations.entries(KEY);
	}

}
