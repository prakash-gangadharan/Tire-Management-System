package com.tiremanagement.registration.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tiremanagement.registration.dto.UserRegistrationDto;
import com.tiremanagement.registration.entity.Role;
import com.tiremanagement.registration.entity.User;
import com.tiremanagement.registration.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    //@Autowired
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User save(UserRegistrationDto registration){
        User user = new User();
        user.setFirstName(registration.getFirstName());
        user.setLastName(registration.getLastName());
        user.setUsername(registration.getEmail());
        user.setEmail(registration.getEmail());
        user.setAddress(registration.getAddress());
        user.setState(registration.getState());
        user.setCountry(registration.getCountry());
        user.setPanNo(registration.getPan());
        user.setContactNo(registration.getContactNo());
        user.setDob(registration.getDob());
        user.setVehicleDetails(registration.getVehicledetails());
        user.setPassword(passwordEncoder.encode(registration.getPassword()));
        user.setRoles(Arrays.asList(new Role("ROLE_USER")));
        return userRepository.save(user);
    }

    
}
