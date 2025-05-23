package com.ufpr.frotas.application.dto;

public class ViagemResponseDTO {
    private Long id;
    private Integer kmInicial;
    private Integer kmFinal;
    private String dataInicio;
    private String dataFim;
    private String obsInicio;
    private String obsFim;

    private AgendamentoRequestDTO agendamento;


    public AgendamentoRequestDTO getAgendamento() {
        return this.agendamento;
    }

    public Integer getKmInicial() {
        return this.kmInicial;
    } 

    public Integer getKmFinal() {
        return this.kmFinal;
    }

    public String getObsInicio() {
        return this.obsInicio;
    }

    public String getObsFim() {
        return this.obsFim;
    }
}
