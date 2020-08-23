package com.tiremanagement.registration.service;

import com.tiremanagement.registration.dto.UserRegistrationDto;
import com.tiremanagement.registration.entity.User;

public interface UserService {

	User findByEmail(String email);

	User save(UserRegistrationDto registration);
}
