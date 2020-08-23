package io.tiremanagement.springsecurityjwt.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.tiremanagement.springsecurityjwt.models.AuthenticationRequest;
import io.tiremanagement.springsecurityjwt.models.AuthenticationResponse;
import io.tiremanagement.springsecurityjwt.service.MyUserDetailsService;
import io.tiremanagement.springsecurityjwt.util.JwtUtil;

@RestController
public class TMSAuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@RequestMapping({ "/api" })
	public String firstPage() {
		return "Hello World";
	}

	
}
