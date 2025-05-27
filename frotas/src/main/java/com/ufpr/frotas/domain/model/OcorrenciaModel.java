package com.ufpr.frotas.domain.model;

import jakarta.persistence.Entity;
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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ocorrencias")
public class OcorrenciaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private String dataRegistro;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "veiculo_id", nullable = false)
    private VeiculoModel veiculo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "motorista_id", nullable = false)
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

    public void setDescricao(String value) {
        this.descricao = value;
    }

    public void setVeiculo(VeiculoModel value) {
        this.veiculo = value;
    }

    public void setMotorista(UserModel value) {
        this.motorista = value;
    }

    public void setDataRegistro(String value) {
        this.dataRegistro = value;
    }
}
