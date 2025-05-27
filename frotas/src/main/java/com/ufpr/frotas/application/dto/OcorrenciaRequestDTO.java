package com.ufpr.frotas.application.dto;

import com.ufpr.frotas.domain.model.UserModel;
import com.ufpr.frotas.domain.model.VeiculoModel;
import lombok.Data;

@Data
public class OcorrenciaRequestDTO {
    private Long id;
    private String descricao;
    private String dataRegistro;
    private VeiculoModel veiculo;
    private UserModel motorista;
    
    public Long getId() {
        return this.id;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public VeiculoModel getVeiculo() {
        return this.veiculo;
    }

    public UserModel getMotorista() {
        return this.motorista;
    } 

    public String getDataRegistro() {
        return this.dataRegistro;
    }
}
