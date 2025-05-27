package com.ufpr.frotas.domain.model;

import com.ufpr.frotas.domain.model.enums.ManutencaoEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "manutencoes")

@AllArgsConstructor
@NoArgsConstructor
public class ManutencaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String data;

    @Enumerated(EnumType.STRING)
    private ManutencaoEnum tipo;

    private String descricao;
    private Double valor;
    private Double quilometragem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "veiculo_id", nullable = false)
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

    public void setData(String value) {
        this.data = value;
    }

    public void setTipo(ManutencaoEnum value) {
        this.tipo = value;
    }

    public void setDescricao(String value) {
        this.descricao = value;
    }

    public void setValor (Double value) {
        this.valor = value;
    } 

    public void setQuilometragem(Double value) {
        this.quilometragem = value;
    }

    public void setVeiculo(VeiculoModel value) {
        this.veiculo = value;
    }

}
