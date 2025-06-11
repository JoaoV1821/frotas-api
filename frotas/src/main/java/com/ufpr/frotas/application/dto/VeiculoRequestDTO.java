package com.ufpr.frotas.application.dto;

import com.ufpr.frotas.domain.model.enums.StatusVeiculoEnum;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class VeiculoRequestDTO {
    private String placa;
    private String modelo;
    private String tipo;
    private String ano;
    private Double quilometragemAtual;
    
    @Enumerated(EnumType.STRING)
    private StatusVeiculoEnum status;

    private String renavam;
    private String chassi;


    public String getPlaca() {
        return this.placa;
    }

    public String getModelo() {
        return this.modelo;
    }

    public String getTipo() {
        return this.tipo;
    }

    public String getAno() {
        return this.ano;
    }

    public Double getQuilometragemAtual( ) {
        return this.quilometragemAtual;
    }

    public StatusVeiculoEnum getStatus() {
        return this.status;
    }

    public String getRenavam() {
        return this.renavam;
    }

    public String getChassi() {
        return this.chassi;
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

    public void setAno(String ano) {
        this.ano = ano;
    }

    public void setQuilometragemAtual(Double quilometragemAtual) {
        this.quilometragemAtual = quilometragemAtual;
    }

    public void setStatus(StatusVeiculoEnum status) {
        this.status = status;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

}
