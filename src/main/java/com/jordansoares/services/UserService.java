package com.jordansoares.services;

import com.jordansoares.dtos.UserDto;
import com.jordansoares.entities.User;

public interface UserService {
    void verifyUser(String email, String password);

    void registerUser(UserDto userDto);

    User getUserById(Integer id);

    UserDto convertEntityToDto(User user);

    User convertDtoEntityTo(UserDto userDto);

    UserDto verifyUserLogin(String email, String password);
}
