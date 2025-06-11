package com.ufpr.frotas.application.dto;

import com.ufpr.frotas.domain.model.enums.StatusVeiculoEnum;


public class VeiculoResponseDTO {
    private Long veiculoId;
    private String placa;
    private String modelo;
    private String tipo;
    private int ano;

    private int quilometragemAtual;
    
    private StatusVeiculoEnum status;

    public Long getId() {
        return this.veiculoId;
    }

    public String getPlaca() {
        return this.placa;
    }

    public String getModelo() {
        return this.modelo;
    }

    public String tipo() {
        return this.tipo;
    }

    public int getAno() {
        return this.ano;
    }

    public int quilometragemAtual( ) {
        return this.quilometragemAtual;
    }

    public StatusVeiculoEnum status() {
        return this.status;
    }

    public void setId(Long id) {
        this.veiculoId = id;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setQuilometragemAtual(int quilometragemAtual) {
        this.quilometragemAtual = quilometragemAtual;
    }

    public void setStatus(StatusVeiculoEnum status) {
        this.status = status;
    }

}
