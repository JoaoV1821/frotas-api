package com.ufpr.frotas.application.dto;

import com.ufpr.frotas.domain.model.VeiculoModel;
import com.ufpr.frotas.domain.model.enums.ManutencaoEnum;

import lombok.Data;

@Data
public class ManuntecaoResponseDTO {

    private Long id;
    private String data;
    private ManutencaoEnum tipo;
    private String descricao;
    private Double valor;
    private Double quilometragem;
    private VeiculoModel veiculo;
    

    public Long getId() {
        return this.id;
    }

    public String getData() {
        return this.data;
    }

    public ManutencaoEnum getTipo() {
        return this.tipo;
    }

    public VeiculoModel getVeiculo() {
        return this.veiculo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public Double getValor() {
        return this.valor;
    }

    public Double getQuilometragem() {
        return this.quilometragem;
    }

}
