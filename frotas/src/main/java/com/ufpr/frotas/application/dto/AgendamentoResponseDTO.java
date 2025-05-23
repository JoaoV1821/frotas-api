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
}
