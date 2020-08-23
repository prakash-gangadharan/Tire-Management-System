package io.tiremanagement.springsecurityjwt.models;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationDto {

	@NotEmpty
	private String firstName;

	@NotEmpty
	private String lastName;

	@NotEmpty
	private String password;

	@NotEmpty
	private String confirmPassword;

	@Email
	@NotEmpty
	private String email;

	@Email
	@NotEmpty
	private String confirmEmail;

	@NotEmpty
	private String address;

	@NotEmpty
	private String state;

	@NotEmpty
	private String country;

	private String pan;

	private String contactNo;

	private String dob;

	private String vehicledetails;

	@AssertTrue
	private Boolean terms;

}
