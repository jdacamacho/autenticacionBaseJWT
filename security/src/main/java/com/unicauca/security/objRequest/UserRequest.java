package com.unicauca.security.Models;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRequest {
    private String username;
    private  String password;
    private String name;
    private String lastname;
    private String role;

    public UserRequest(){

    }

}
