package com.ufpr.frotas.application.dto;

import com.ufpr.frotas.domain.model.UserModel;
import com.ufpr.frotas.domain.model.VeiculoModel;
import com.ufpr.frotas.domain.model.enums.TipoCombustivelEnum;

import lombok.Data;

@Data
public class AbastecimentoResponseDTO {
    private Long id;
    private String data;
    private TipoCombustivelEnum tipoCombustivel;
    private Double valor;
    private Double quilometragem;

    private VeiculoResponseDTO veiculo;
    private UserResponseDTO motorista;

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

    public VeiculoResponseDTO getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(VeiculoResponseDTO veiculo) {
        this.veiculo = veiculo;
    }

    public UserResponseDTO getMotorista() {
        return motorista;
    }

    public void setMotorista(UserResponseDTO motorista) {
        this.motorista = motorista;
    }
}
