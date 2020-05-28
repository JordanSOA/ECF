package com.jordansoares.controllers;

import com.jordansoares.dtos.UserDto;
import com.jordansoares.dtos.UserLoginDto;
import com.jordansoares.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping
public class LoginController {


    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public void registerUser(@RequestBody @Valid UserDto userDto){
        userService.registerUser(userDto);
    }

    @PostMapping("/login")
    public UserDto isUserExist(@RequestBody @Valid UserLoginDto user){
        return userService.verifyUserLogin(user.getEmail(),user.getPassword());
    }

}