package com.ufpr.frotas.application.dto;

public class AuthResponseDTO {
    private String jwt;

    public AuthResponseDTO(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
    
}
