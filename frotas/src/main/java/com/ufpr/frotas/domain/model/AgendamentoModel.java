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

    public void setDataSaida(String value) {
        this.dataSaida = value;
    }

    public void setDataRetorno(String value) {
        this.dataRetorno = value;
    }

    public void setJustificativa(String value) {
            this.justificativa = value;
        }

    public void setDestino(String value) {

        this.destino = value;
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

    public String getDataInicio() {
        return this.dataInicio;
    }

    public String getDataFim() {
        return this.dataFim;
    }

    public String getObservacaoInicio() {
        return this.observacaoInicio;
    }

    public String getObservacaoFim() {
        return this.observacaoFim;
    }

    public void setDataInicio(String value) {
        this.dataInicio = value;
    }

    public void setDataFim(String value) {
        this.dataFim = value;
    }

    public void setObservacaoInicio(String value) {
        this.observacaoInicio = value;
    }

    public void setObservacaoFim(String value) {
        this.observacaoFim = value;
    }

    public Double getQuilometragemInicial() {
        return this.quilometragemInicial;
    }

    public Double getQuilometragemFinal() {
        return this.quilometragemFinal;
    }

    public void setQuilometragemInicial(Double value) {
        this.quilometragemInicial = value;
    }

    public void setQuilometragemFinal(Double value) {
        this.quilometragemFinal = value;
    }

}
