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

    public String tipo() {
        return this.tipo;
    }

    public String getAno() {
        return this.ano;
    }

    public Double quilometragemAtual( ) {
        return this.quilometragemAtual;
    }

    public StatusVeiculoEnum status() {
        return this.status;
    }

    public String renavam() {
        return this.renavam;
    }

    public String getChassi() {
        return this.chassi;
    } 
}
