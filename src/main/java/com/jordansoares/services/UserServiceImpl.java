package com.jordansoares.services;

import com.jordansoares.dtos.UserDto;
import com.jordansoares.entities.User;
import com.jordansoares.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void verifyUser(String email, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);

        if(!passwordEncoder.matches(password, userDetails.getPassword())){
            throw new BadCredentialsException("Bad credentials"+ email);
        }

    }

    @Override
    public void registerUser(UserDto userDto) {
        User user = new User(userDto.getFirstname(), userDto.getLastname(),userDto.getPassword(),userDto.getEmail(), userDto.getBirthdate(), userDto.getLastKnownPresence());
        userRepository.save(user);
    }
}
