package com.tiremanagement.registration.web;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiremanagement.registration.dto.UserRegistrationDto;
import com.tiremanagement.registration.entity.User;
import com.tiremanagement.registration.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
public class UserDetailsController {
    
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public ResponseEntity<User> showUpdateForm(@PathVariable("id") long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<User> registerUserAccount(@PathVariable("id") long id, @Valid @RequestBody UserRegistrationDto userDto,
            BindingResult result){
        if (result.hasErrors()) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        userRepository.updateUsername(id, userDto.getEmail());
        Optional<User> user = userRepository.findById(id);
        return new ResponseEntity<User>(user.get(), HttpStatus.OK);
    }
    
}
