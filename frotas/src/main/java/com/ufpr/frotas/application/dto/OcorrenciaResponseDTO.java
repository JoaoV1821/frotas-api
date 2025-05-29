package com.ufpr.frotas.application.dto;

import com.ufpr.frotas.domain.model.UserModel;

import lombok.Data;

@Data
public class OcorrenciaResponseDTO {

    private Long id;
    private String descricao;
    private String dataRegistro;
    private VeiculoResponseDTO veiculo;
    private UserModel motorista;
    

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

    private UserModel getMotorista() {
        return this.motorista;
    }
    
}
