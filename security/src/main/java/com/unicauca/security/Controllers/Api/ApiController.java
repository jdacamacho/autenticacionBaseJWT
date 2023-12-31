package com.unicauca.security.Controllers.Api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {
    
    @PostMapping("/demo")
    @PreAuthorize("hasRole('Administrador')")
    public String welcome(){
        return "endpoint protected";
    }
}
