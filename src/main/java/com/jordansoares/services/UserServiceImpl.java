package com.jordansoares.services;

import com.jordansoares.dtos.UserDto;
import com.jordansoares.entities.User;
import com.jordansoares.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Verify User is registred - Login
     * @params email, password
     * @return void
     */
    @Override
    @Transactional
    public void verifyUser(String email, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);

        if(!passwordEncoder.matches(password, userDetails.getPassword())){
            throw new BadCredentialsException("Bad credentials"+ email);
        }

    }

    @Override
    @Transactional
    public void registerUser(UserDto userDto) {
        User user = new User(userDto.getFirstname(), userDto.getLastname(), passwordEncoder.encode(userDto.getPassword()),userDto.getEmail(), userDto.getBirthdate(), userDto.getLastKnownPresence());
        userRepository.save(user);
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public UserDto verifyUserLogin(String email, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        User byId = userRepository.findByEmail(email);

        if(!passwordEncoder.matches(password, userDetails.getPassword())){
            throw new BadCredentialsException("Bad credentials"+ email);
        } else {
            LocalDateTime now = LocalDateTime.now();
            byId.setLastKnownPresence(now);
            userRepository.save(byId);
            return convertEntityToDto(byId);
        }
    }

    @Override
    public UserDto convertEntityToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setFirstname(user.getFirstname());
        userDto.setLastname(user.getLastname());
        userDto.setBirthdate(user.getBirthdate());
        userDto.setLastKnownPresence(user.getLastKnownPresence());
        return userDto;
    }

    @Override
    public User convertDtoEntityTo(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setBirthdate(userDto.getBirthdate());
        return user;
    }
}
