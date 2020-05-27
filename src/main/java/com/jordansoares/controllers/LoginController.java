package com.jordansoares.controllers;

import com.jordansoares.dtos.UserDto;
import com.jordansoares.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping
public class LoginController {


    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public void isUserExist(@RequestBody UserDto user){
        userService.verifyUser(user.getEmail(),user.getPassword());
    }

    @PostMapping("/register")
    public void registerUser(@RequestBody UserDto userDto){
        userService.registerUser(userDto);
    }
}
