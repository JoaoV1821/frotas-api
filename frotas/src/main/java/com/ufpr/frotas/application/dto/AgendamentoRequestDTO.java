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
    private StatusAgendamentoEnum status;
    

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
      return this.status;
  }

}
