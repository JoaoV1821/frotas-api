package com.ufpr.frotas.application.dto;

import lombok.Data;

@Data
public class ViagemRequestDTO {
    private Long id;
    private Double kmInicial;
    private Double kmFinal;
    private String obsInicio;
    private String obsFim;
    private String dataFim;
    private String dataInicio;


    private AgendamentoRequestDTO agendamento;


    public AgendamentoRequestDTO getAgendamento() {
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

    public String getDataInicio() {
        return this.dataInicio;
    }

    
    public String getDataFim() {
        return this.dataFim;
    }
}
