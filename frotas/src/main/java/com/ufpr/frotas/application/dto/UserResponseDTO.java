package com.ufpr.frotas.application.dto;

import com.ufpr.frotas.domain.model.enums.PerfilEnum;

import lombok.Data;

@Data
public class UserResponseDTO {
    private Long id;
    private String nome;
    private String email;
    private PerfilEnum perfil;
    private String senha;
    private Boolean ativo;
    private String telefone;
    private String cnh;
    private String validadeCnh;
    private EnderecoRequestDTO endereco;



    
    public Long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public PerfilEnum getPerfil() {
        return this.perfil;
    }

    public Boolean getAtivo() {
        return this.ativo;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public String getCnh() {
        return this.cnh;
    }

    public String getValidadeCnh() {
        return this.validadeCnh;
    }

    public String getSenha() {
        return this.senha;
    }

    public EnderecoRequestDTO getEndereco() {
        return this.endereco;
    }
}
