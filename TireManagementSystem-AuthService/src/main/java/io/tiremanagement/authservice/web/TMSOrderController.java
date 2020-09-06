package io.tiremanagement.authservice.web;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.tiremanagement.authservice.entity.Order;
import io.tiremanagement.authservice.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/order")
@Slf4j
public class TMSOrderController {

	@Autowired
	private OrderRepository orderRepository;
	
    //@Autowired
    private RestTemplate restTemplate = new RestTemplate();

    // create headers
    HttpHeaders headers = new HttpHeaders();
    
    private final String getOrderInfoUrl = "http://localhost:8083/getInfo";
    private final String findAllOrdersUrl = "http://localhost:8083/findAllOrders";
    
    @GetMapping("/getInfo")
    @HystrixCommand(fallbackMethod = "defaultProductList")
    public Object registerUserAccount() throws RestClientException, URISyntaxException {
    	 headers.add("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2YW5pdGhhMTguZ0BnbWFpbC5jb20iLCJleHAiOjE1OTk0MzI4MDQsImlhdCI6MTU5OTM5NjgwNH0.xVoSJk4iQTKW11bYYfaWPiUdp9fM-Hh1d0msi3u6jLM");
		URI uri = new URI(getOrderInfoUrl);
		
		// Create request
	    HttpEntity request = new HttpEntity(headers);
	    // Make a request
	    ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);

		return response;
	}

	@GetMapping("/findAllOrders")
	@HystrixCommand(fallbackMethod = "defaultProductList")
	public Object findAllUserOrders()
			throws RestClientException, URISyntaxException {
		//log.info("TMSOrderController >> findAllUserOrders >> "+ token);
	
		headers.add("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2YW5pdGhhMTguZ0BnbWFpbC5jb20iLCJleHAiOjE1OTk0MzI4MDQsImlhdCI6MTU5OTM5NjgwNH0.xVoSJk4iQTKW11bYYfaWPiUdp9fM-Hh1d0msi3u6jLM");
		URI uri = new URI(findAllOrdersUrl);
		
		// Create request
	    HttpEntity request = new HttpEntity(headers);
	    // Make a request
	    ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);

		return response;
	}

	public Map<Long, Order> defaultProductList() {
		//return Arrays.asList("Order 1", "Order 2");
		return orderRepository.findAll();
		
	}
}

