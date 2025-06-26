package com.ufpr.frotas.application.dto;

import com.ufpr.frotas.domain.model.VeiculoModel;
import com.ufpr.frotas.domain.model.enums.ManutencaoEnum;

import lombok.Data;

@Data
public class ManutencaoRequestDTO {
    private Long id;
    private String data;
    private ManutencaoEnum tipo;
    private String descricao;
    private Double valor;
    private Double quilometragem;
    private Long veiculo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ManutencaoEnum getTipo() {
        return tipo;
    }

    public void setTipo(ManutencaoEnum tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(Double quilometragem) {
        this.quilometragem = quilometragem;
    }

    public Long getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Long veiculo) {
        this.veiculo = veiculo;
    }
}
