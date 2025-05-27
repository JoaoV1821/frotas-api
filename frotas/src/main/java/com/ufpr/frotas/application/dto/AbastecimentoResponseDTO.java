package com.ufpr.frotas.application.dto;

import com.ufpr.frotas.domain.model.UserModel;
import com.ufpr.frotas.domain.model.VeiculoModel;
import com.ufpr.frotas.domain.model.enums.TipoCombustivelEnum;

import lombok.Data;

@Data
public class AbastecimentoResponseDTO {
    private Long id;
    private String data;
    private TipoCombustivelEnum tipo_combustivel;
    private Double valor;
    private Double quilometragem;

    private VeiculoModel veiculo;
    private UserModel motorista;


    public Long getId() {
        return this.id;
    }

    public String getData() {
        return this.data;
    }

    public Double getValor() {
        return this.valor;
    }

    public Double getQuilometragem() {
        return this.quilometragem;
    }

    public VeiculoModel getVeiculo() {
        return this.veiculo;
    }

    public UserModel getMotorista() {
        return this.motorista;
    }
}
