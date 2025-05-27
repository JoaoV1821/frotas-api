package com.ufpr.frotas.application.dto;

import lombok.Data;

@Data
public class OcorrenciaResponseDTO {

    private Long id;
    private String descricao;
    private String dataRegistro;
    private VeiculoResponseDTO veiculo;
    private UserResponseDTO motorista;
    

    private Long getId() {
        return this.id;
    }

    private String getDescricao() {
        return this.descricao;
    }

    private String getDataRegistro() {
        return this.dataRegistro;
    }

    private VeiculoResponseDTO getVeiculo() {
        return this.veiculo;
    }

    private UserResponseDTO getMotorista() {
        return this.motorista;
    }
    
}
