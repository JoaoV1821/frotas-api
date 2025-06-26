package com.ufpr.frotas.domain.model;

import com.ufpr.frotas.domain.model.enums.StatusAgendamentoEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;


@Entity
@Table(name = "agendamentos")
@NoArgsConstructor
@AllArgsConstructor
public class AgendamentoModel {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dataSaida;
    private String dataRetorno;

    private Double quilometragemInicial;
    private Double quilometragemFinal;
    private String dataInicio;
    private String dataFim;
    private String observacaoInicio;
    private String observacaoFim;


    @Enumerated(EnumType.STRING)
    private StatusAgendamentoEnum statusAgenda;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "veiculoId", nullable = false)
    private VeiculoModel veiculo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "motorista_id", nullable = false)
    
    private UserModel motorista;

    private String destino; 

    private String justificativa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getDataRetorno() {
        return dataRetorno;
    }

    public void setDataRetorno(String dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    public Double getQuilometragemInicial() {
        return quilometragemInicial;
    }

    public void setQuilometragemInicial(Double quilometragemInicial) {
        this.quilometragemInicial = quilometragemInicial;
    }

    public Double getQuilometragemFinal() {
        return quilometragemFinal;
    }

    public void setQuilometragemFinal(Double quilometragemFinal) {
        this.quilometragemFinal = quilometragemFinal;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getObservacaoInicio() {
        return observacaoInicio;
    }

    public void setObservacaoInicio(String observacaoInicio) {
        this.observacaoInicio = observacaoInicio;
    }

    public String getObservacaoFim() {
        return observacaoFim;
    }

    public void setObservacaoFim(String observacaoFim) {
        this.observacaoFim = observacaoFim;
    }

    public StatusAgendamentoEnum getStatusAgenda() {
        return statusAgenda;
    }

    public void setStatusAgenda(StatusAgendamentoEnum statusAgenda) {
        this.statusAgenda = statusAgenda;
    }

    public VeiculoModel getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(VeiculoModel veiculo) {
        this.veiculo = veiculo;
    }

    public UserModel getMotorista() {
        return motorista;
    }

    public void setMotorista(UserModel motorista) {
        this.motorista = motorista;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }
}
