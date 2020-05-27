package com.jordansoares.controllers;

import com.jordansoares.dtos.UserDto;
import com.jordansoares.entities.User;
import com.jordansoares.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/profil/{id}")
    public UserDto getUserInfosbyId(@PathVariable(name = "id")Integer id){
        User user = userService.getUserById(id);
        return userService.convertEntityToDto(user);
    }
}
