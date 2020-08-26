package com.tiremanagement.registration.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiremanagement.registration.dto.UserRegistrationDto;
import com.tiremanagement.registration.entity.User;
import com.tiremanagement.registration.service.UserService;

@RestController
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> registerUserAccount(@Valid @RequestBody UserRegistrationDto userDto,
                                      BindingResult result){

        User existing = userService.findByEmail(userDto.getEmail());
        if (existing != null){
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()){
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<User>(userService.save(userDto), HttpStatus.OK);
    }

}
