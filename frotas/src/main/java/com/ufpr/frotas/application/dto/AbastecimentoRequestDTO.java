package com.ufpr.frotas.application.dto;

import com.ufpr.frotas.domain.model.UserModel;
import com.ufpr.frotas.domain.model.VeiculoModel;
import com.ufpr.frotas.domain.model.enums.TipoCombustivelEnum;

import lombok.Data;

@Data
public class AbastecimentoRequestDTO {
    
    private Long id;
    private String data;
    private TipoCombustivelEnum tipoCombustivel;
    private Double valor;
    private Double quilometragem;

    private VeiculoModel veiculo;
    private UserModel motorista;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public TipoCombustivelEnum getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(TipoCombustivelEnum tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(Double quilometragem) {
        this.quilometragem = quilometragem;
    }

    public VeiculoModel getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(VeiculoModel veiculo) {
        this.veiculo = veiculo;
    }

    public UserModel getMotorista() {
        return motorista;
    }

    public void setMotorista(UserModel motorista) {
        this.motorista = motorista;
    }
}
