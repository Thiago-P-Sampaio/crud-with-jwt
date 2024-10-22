package com.example.login_auth_rest_api_test2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



import java.util.UUID;

@Entity
@Table (name = "user")
@AllArgsConstructor
@NoArgsConstructor
public class User_entity {

    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String email;
    private String password;

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) { this.email = email;}

    public void setName(String name) {
        this.name = name;
    }
}
