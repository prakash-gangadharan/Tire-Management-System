package io.tiremanagement.authservice.models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor // need default constructor for JSON Parsing 
@AllArgsConstructor
public class AuthenticationRequest implements Serializable {

	private String username;
	private String password;

}
