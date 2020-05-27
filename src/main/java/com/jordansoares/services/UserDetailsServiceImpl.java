package com.jordansoares.services;


import com.jordansoares.entities.User;
import com.jordansoares.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User byId = userRepository.findByEmail(username);
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("USER");
        Set<SimpleGrantedAuthority> collect = new HashSet<>();
        collect.add(authority);
        return new org.springframework.security.core.userdetails.User(byId.getEmail(), byId.getPassword(),collect);
    }
}
