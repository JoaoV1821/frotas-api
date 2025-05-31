package com.ufpr.frotas.application.dto;

import com.ufpr.frotas.domain.model.enums.PerfilEnum;

import lombok.Data;

@Data
public class UserRequestDTO {
    private String nome;
    private String email;
    private String senha;
    private PerfilEnum perfil;
    private Boolean ativo;
    private String telefone;
    private String cnh;
    private String validadeCnh;
    private EnderecoRequestDTO endereco;


    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public String getSenha() {
        return this.senha;
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

    public EnderecoRequestDTO getEndereco() {
        return this.endereco;
    }


    

}
