package com.unicauca.security.Controllers.Auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.security.Models.UserRequest;
import com.unicauca.security.Service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam("username") String username,@RequestParam("password") String password){
        return ResponseEntity.ok(authService.login(username, password)) ;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserRequest request){
        return ResponseEntity.ok(authService.register(request));
    }
}
