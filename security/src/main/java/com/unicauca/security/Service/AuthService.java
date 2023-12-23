package com.unicauca.security.Service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.unicauca.security.Entity.User;
import com.unicauca.security.JWT.JwtService;
import com.unicauca.security.Models.UserRequest;
import com.unicauca.security.Repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepostitory;
    private final JwtService jwtService;
    private final PasswordEncoder passworEncoder;
    private final AuthenticationManager authenticationManager;

    public String login(String username,String password){
        String token = "";
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        UserDetails user = this.userRepostitory.findByUsername(username).orElseThrow();
        token = this.jwtService.getToken(user);
        return token;
    }

    public String register(UserRequest request){
        User user = new User();
        user.setIdUser(0);
        user.setUsername(request.getUsername());
        user.setPassword(passworEncoder.encode(request.getPassword()));
        user.setName(request.getName());
        user.setLastname(request.getLastname());
        user.setRole(request.getRole());
       
        userRepostitory.save(user);
        return jwtService.getToken(user);
    }
}
