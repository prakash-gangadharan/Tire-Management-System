package io.tiremanagement.authservice.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.tiremanagement.authservice.entity.Order;
import io.tiremanagement.authservice.repository.OrderRepository;


@RestController
public class RedisController {

	@Autowired
	private OrderRepository orderRepository;

	@RequestMapping("/save")
	public String save() {
		// save a single order
		orderRepository.save(new Order(1, "Jack", "Smith", "Tire"));
		orderRepository.save(new Order(2, "Adam", "Johnson", "Windshield"));
		orderRepository.save(new Order(3, "Kim", "Smith", "wiper"));
		orderRepository.save(new Order(4, "David", "Williams", "Tire"));
		orderRepository.save(new Order(5, "Peter", "Davis", "CarTube"));

		return "Done";
	}

	@RequestMapping("/findall")
	public String findAll() {
		String result = "";
		Map<Long, Order> orders = orderRepository.findAll();

		for (Order order : orders.values()) {
			result += order.toString() + "<br>";
		}

		return result;
	}

	@RequestMapping("/find")
	public String findById(@RequestParam("id") Long id) {
		String result = "";
		result = orderRepository.find(id).toString();
		return result;
	}
}
