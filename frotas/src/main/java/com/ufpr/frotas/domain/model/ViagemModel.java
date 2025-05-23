package com.ufpr.frotas.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "viagens")
public class ViagemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @OneToOne
    @JoinColumn(name = "agendamentoId", nullable = false, unique = true)
    private AgendamentoModel agendamento;

    private Double kmInicial;
    private Double kmFinal;
    private String dataInicio;
    private String dataFim;
    private String obsInicio;
    private String obsFim;

    
    public AgendamentoModel getAgendamento() {
        return this.agendamento;
    }

    public Double getKmInicial() {
        return this.kmInicial;
    } 

    public Double getKmFinal() {
        return this.kmFinal;
    }

    public String getObsInicio() {
        return this.obsInicio;
    }

    public String getObsFim() {
        return this.obsFim;
    }

    public void setAgendamento(AgendamentoModel value) {
        this.agendamento = value;
    }

    public void setDataInicio(String value) {
        this.dataInicio = value;
    }


}
