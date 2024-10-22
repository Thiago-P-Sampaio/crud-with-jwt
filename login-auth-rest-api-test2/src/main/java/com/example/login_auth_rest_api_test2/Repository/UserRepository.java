package com.example.login_auth_rest_api_test2.Repository;

import com.example.login_auth_rest_api_test2.model.User_entity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository <User_entity, UUID> {

       Optional<User_entity> FindByEmail(String email);
}
