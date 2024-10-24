package com.example.login_auth_rest_api_test2.DTO;


import com.example.login_auth_rest_api_test2.model.user.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
