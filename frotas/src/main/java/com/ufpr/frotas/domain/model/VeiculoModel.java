package com.ufpr.frotas.domain.model;

import java.util.ArrayList;
import java.util.List;


import com.ufpr.frotas.domain.model.enums.StatusVeiculoEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "veiculos")
public class VeiculoModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long veiculoId;
    private String placa;

    private String modelo;

    private String tipo;

    private String ano;
    private Double quilometragemAtual;

    @Enumerated(EnumType.STRING)
    private StatusVeiculoEnum status;
    
    private String renavam;
    private String chassi;

    @OneToMany(mappedBy = "veiculo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ManutencaoModel> manutencoes = new ArrayList<>();

    @OneToMany(mappedBy = "veiculo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AbastecimentoModel> abastecimentos = new ArrayList<>();

    @OneToMany(mappedBy = "veiculo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OcorrenciaModel> ocorrencias = new ArrayList<>();

    @OneToMany(mappedBy = "veiculo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AgendamentoModel> agendamentos = new ArrayList<>();

    public Long getId() {
        return this.veiculoId;
    }
    
    public StatusVeiculoEnum getStatus() {
        return this.status;
    }

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

    public String getRenavam() {
        return this.renavam;
    }

    public String getChassi() {
        return this.chassi;
    } 

    public void setStatus(StatusVeiculoEnum value) {
        this.status = value;
    }

    public void setId(Long veiculoId) {
        this.veiculoId = veiculoId;
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

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }
}



