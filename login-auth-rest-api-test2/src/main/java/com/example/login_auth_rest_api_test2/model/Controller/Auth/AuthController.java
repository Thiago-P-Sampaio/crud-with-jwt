package com.example.login_auth_rest_api_test2.model.Controller.Auth;

import com.example.login_auth_rest_api_test2.DTO.AuthenticationDTO;
import com.example.login_auth_rest_api_test2.DTO.LoginResponseDTO;
import com.example.login_auth_rest_api_test2.DTO.RegisterDTO;
import com.example.login_auth_rest_api_test2.Repository.UserRepository;
import com.example.login_auth_rest_api_test2.infra.security.TokenService;
import com.example.login_auth_rest_api_test2.model.user.User_entity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authManager;

    @Autowired
    TokenService tokenService;

    @Autowired
    UserRepository UserRepository;

    @PostMapping("/login")
    public ResponseEntity  login(@RequestBody @Valid AuthenticationDTO client){
        var UserPassword = new UsernamePasswordAuthenticationToken(client.login(), client.password());
        var auth =  this.authManager.authenticate(UserPassword);

        var token = tokenService.GenerateToken((User_entity) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity registerNewUser(@RequestBody @Valid RegisterDTO registerData){
     if(this.UserRepository.findByLogin(registerData.login()) != null) return ResponseEntity.badRequest().build();

     String HashPassword = new BCryptPasswordEncoder().encode(registerData.password());
        User_entity NewUser = new User_entity(registerData.login(), HashPassword, registerData.role());

        this.UserRepository.save(NewUser);
        return  ResponseEntity.ok().build();
    }
}
