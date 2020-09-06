package io.tiremanagement.authservice.web;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import io.tiremanagement.authservice.models.UserRegistrationDto;

@RestController
@RequestMapping("/user")
public class TMSUserController {
	
    //@Autowired
    private RestTemplate restTemplate = new RestTemplate();
    
    private final String registrationUrl = "http://localhost:8081/registration";
    private final String updateUrl = "http://localhost:8081/api/user/update";
    
    @PostMapping("/registration")
    public ResponseEntity<Object> registerUserAccount(@Valid @RequestBody UserRegistrationDto userDto,
			BindingResult result) throws RestClientException, URISyntaxException {
		URI uri = new URI(registrationUrl);
		ResponseEntity<Object> response = restTemplate.postForEntity(uri, userDto, Object.class);
		return response;
	}

	@PostMapping("/update/{id}")
	public ResponseEntity<Object> updateUserAccount(@PathVariable("id") long id,
			@Valid @RequestBody UserRegistrationDto userDto, BindingResult result)
			throws RestClientException, URISyntaxException {
		URI uri = new URI(updateUrl+"/"+id);
		ResponseEntity<Object> response = restTemplate.postForEntity(uri, userDto, Object.class);
		return response;
	}
}

