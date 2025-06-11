package com.ufpr.frotas.application.dto;

import com.ufpr.frotas.domain.model.enums.StatusAgendamentoEnum;

import lombok.Data;


@Data
public class AgendamentoRequestDTO {
    private Long agendamentoId;
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
    return this.agendamentoId;
  }
  
  public VeiculoResponseDTO getVeiculo() {
    return this.veiculo;
  }

  public UserResponseDTO getMotorista() {
    return this.motorista;
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

  public StatusAgendamentoEnum getAgendamentoStatus() {
      return this.statusAgenda;
  }

    public String getDataInicio() {
        return this.dataInicio;
    }

    public String getDataFim() {
        return this.dataFim;
    }

    public Double getQuilometragemInicial() {
        return this.quilometragemInicial;
    }

    public Double getQuilometragemFinal() {
        return this.quilometragemFinal;
    }

    public String getObservacaoInicio() {
        return this.observacaoInicio;
    }

    public String getObservacaoFim() {
        return this.observacaoFim;
    }

    public void setId(Long id) {
        this.agendamentoId = id;
    }

    public void setVeiculo(VeiculoResponseDTO veiculo) {
        this.veiculo = veiculo;
    }

    public void setMotorista(UserResponseDTO motorista) {
        this.motorista = motorista;
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

    public void setStatus(StatusAgendamentoEnum status) {
        this.statusAgenda = status;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public void setQuilometragemInicial(Double quilometragemInicial) {
        this.quilometragemInicial = quilometragemInicial;
    }

    public void setQuilometragemFinal(Double quilometragemFinal) {
        this.quilometragemFinal = quilometragemFinal;
    }

    public void setObservacaoInicio(String observacaoInicio) {
        this.observacaoInicio = observacaoInicio;
    }

    public void setObservacaoFim(String observacaoFim) {
        this.observacaoFim = observacaoFim;
    }

}
