package com.ufpr.frotas.application.dto;

import org.springframework.security.core.userdetails.UserDetails;

public class AuthResponseDTO {
    private String jwt;
    private UserDetails userDetails;

    public AuthResponseDTO(String jwt, UserDetails userDetails) {
        this.jwt = jwt;
        this.userDetails = userDetails;
    }

    public String getJwt() {
        return jwt;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }
    
}
