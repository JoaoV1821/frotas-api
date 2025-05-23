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
    private Long agendamentoId;

    private String dataSaida;
    private String dataRetorno;
    
    @OneToOne(mappedBy = "agendamento", cascade = CascadeType.ALL, orphanRemoval = true)
    private ViagemModel viagem;


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
    return this.agendamentoId;
  }
  public VeiculoModel getVeiculo() {
    return this.veiculo;
  }

  public UserModel getMotorista() {
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

  public void setVeiculo(VeiculoModel value) {
        this.veiculo = value;
  }

  public void setMotorista(UserModel value) {
    this.motorista = value;
  }

  public void setStatus(StatusAgendamentoEnum value) {
    this.statusAgenda = value;
  }

  public StatusAgendamentoEnum getStatus() {
      return this.statusAgenda;
  }

}
