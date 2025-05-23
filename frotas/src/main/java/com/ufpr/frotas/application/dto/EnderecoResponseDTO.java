package com.ufpr.frotas.application.dto;

import lombok.Data;


@Data
public class EnderecoResponseDTO {
    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;
    private String complemento;
    private String numero;


    
    public String getCep() {
        return this.cep;
    }

    public String getLogradouro() {
        return this.logradouro;

    }

    public String getBairro() {
        return this.bairro;
    }

    public String getCidade() {
        return this.cidade;
    }

    public String getEstado() {
        return this.estado;
    }

    public String getComplemento() {
        return this.complemento;
    }

    public String getNumero() {
        return this.numero;
    }
}
