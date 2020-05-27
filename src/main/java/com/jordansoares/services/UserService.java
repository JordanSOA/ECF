package com.jordansoares.services;

import com.jordansoares.dtos.UserDto;

public interface UserService {
    void verifyUser(String email, String password);

    void registerUser(UserDto userDto);
}
