package io.tiremanagement.authservice.web;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/order")
public class TMSOrderController {
	
    //@Autowired
    private RestTemplate restTemplate = new RestTemplate();

    // create headers
    HttpHeaders headers = new HttpHeaders();
    
    private final String getOrderInfoUrl = "http://localhost:8083/getInfo";
    private final String findAllOrdersUrl = "http://localhost:8083/findAllOrders";
    
    @GetMapping("/getInfo")
    @HystrixCommand(fallbackMethod = "defaultProductList")
    public Object registerUserAccount() throws RestClientException, URISyntaxException {
    	 headers.add("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2YW5pdGhhMTguZ0BnbWFpbC5jb20iLCJleHAiOjE1OTkzMjgzNjgsImlhdCI6MTU5OTI5MjM2OH0.Dvak9C41GE33fGW4kPoLGQpKG1KpIYRJx7wCIXHiGRE");
		URI uri = new URI(getOrderInfoUrl);
		
		// Create request
	    HttpEntity request = new HttpEntity(headers);
	    // Make a request
	    ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);

		return response;
	}

	@GetMapping("/findAllOrders")
	@HystrixCommand(fallbackMethod = "defaultProductList")
	public Object updateUserAccount()
			throws RestClientException, URISyntaxException {
   	 headers.add("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2YW5pdGhhMTguZ0BnbWFpbC5jb20iLCJleHAiOjE1OTkzMjgzNjgsImlhdCI6MTU5OTI5MjM2OH0.Dvak9C41GE33fGW4kPoLGQpKG1KpIYRJx7wCIXHiGRE");
		URI uri = new URI(findAllOrdersUrl);
		
		// Create request
	    HttpEntity request = new HttpEntity(headers);
	    // Make a request
	    ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);

		return response;
	}

	public List<String> defaultProductList() {
		return Arrays.asList("Order 1", "Order 2");
	}
}

