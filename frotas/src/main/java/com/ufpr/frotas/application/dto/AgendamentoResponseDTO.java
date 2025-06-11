package com.ufpr.frotas.application.dto;


import com.ufpr.frotas.domain.model.enums.StatusAgendamentoEnum;

public class AgendamentoResponseDTO {
    private Long agendamentoId;
    
    private StatusAgendamentoEnum statusAgenda;
    private String dataSaida;
    private String dataRetorno;
    private String justificativa;
    private String destino;

    private UserResponseDTO motorista;
    private VeiculoResponseDTO veiculo;

    private String dataInicio;
    private String dataFim;
    private Double quilometragemInicial;
    private Double quilometragemFinal;
    private String observacaoInicio;
    private String observacaoFim;


  public Long getId() {
    return this.agendamentoId;
  }

  public String getDataSaida() {
    return this.dataSaida;
  }

  public String getDataRetorno() {
    return this.dataRetorno;
  }

  public String getJustificativa() {
    return this.justificativa;
  }

  public String getDestino() {
    return this.destino;
  }

  public UserResponseDTO getMotorista() {
    return this.motorista;
  }

  public VeiculoResponseDTO getVeiculo() {
    return this.veiculo;
  }

  public StatusAgendamentoEnum getStatus() {
    return this.statusAgenda;
  }

    public void setId(Long id) {
        this.agendamentoId = id;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public void setDataRetorno(String dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setMotorista(UserResponseDTO motorista) {
        this.motorista = motorista;
    }

    public void setVeiculo(VeiculoResponseDTO veiculo) {
        this.veiculo = veiculo;
    }

    public void setStatus(StatusAgendamentoEnum status) {
        this.statusAgenda = status;
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
