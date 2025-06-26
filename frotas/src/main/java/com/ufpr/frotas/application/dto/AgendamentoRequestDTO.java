package com.ufpr.frotas.application.dto;

import com.ufpr.frotas.domain.model.enums.StatusAgendamentoEnum;

import lombok.Data;


@Data
public class AgendamentoRequestDTO {
    private Long id;
    private VeiculoResponseDTO veiculo ;
    private UserResponseDTO motorista;
    private String dataSaida;
    private String dataRetorno;
    private String justificativa;
    private String destino;
    private StatusAgendamentoEnum statusAgenda;
    private String dataInicio;
    private String dataFim;
    private Double quilometragemInicial;
    private Double quilometragemFinal;
    private String observacaoInicio;
    private String observacaoFim;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VeiculoResponseDTO getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(VeiculoResponseDTO veiculo) {
        this.veiculo = veiculo;
    }

    public UserResponseDTO getMotorista() {
        return motorista;
    }

    public void setMotorista(UserResponseDTO motorista) {
        this.motorista = motorista;
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

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public StatusAgendamentoEnum getStatusAgenda() {
        return statusAgenda;
    }

    public void setStatusAgenda(StatusAgendamentoEnum statusAgenda) {
        this.statusAgenda = statusAgenda;
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
}
