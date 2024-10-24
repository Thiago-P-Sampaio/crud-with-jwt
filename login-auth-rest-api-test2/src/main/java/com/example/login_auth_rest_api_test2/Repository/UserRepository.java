package com.example.login_auth_rest_api_test2.Repository;

import com.example.login_auth_rest_api_test2.model.user.User_entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository <User_entity, UUID> {

       UserDetails findByLogin(String login);
}
