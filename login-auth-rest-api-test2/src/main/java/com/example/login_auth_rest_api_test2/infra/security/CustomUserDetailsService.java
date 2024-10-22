package com.example.login_auth_rest_api_test2.infra.security;

import com.example.login_auth_rest_api_test2.Repository.UserRepository;
import com.example.login_auth_rest_api_test2.model.User_entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;

public class CustomUserDetailsService implements UserDetailsService {
   @Autowired
   private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User_entity user = this.repository.FindByEmail(username).orElseThrow(()-> new UsernameNotFoundException("User not Found!!"));
        return  new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }
}
