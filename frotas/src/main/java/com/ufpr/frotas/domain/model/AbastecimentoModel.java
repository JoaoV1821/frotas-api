package com.ufpr.frotas.domain.model;

import com.ufpr.frotas.domain.model.enums.TipoCombustivelEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "abastecimentos")
public class AbastecimentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String data;

    @Enumerated(EnumType.STRING)
    private TipoCombustivelEnum tipoCombustivel;

    private Double valor;
    private Double quilometragem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "veiculo_id", nullable = false)
    private VeiculoModel veiculo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "motorista_id", nullable = false)
    private UserModel motorista;

    public Long getId() {
        return this.id;
    }

    public String getData() {
        return this.data;
    }

    public Double getValor() {
        return this.valor;
    }

    public TipoCombustivelEnum getTipoCombustivel() {
        return this.tipoCombustivel;
    }

    public Double getQuilometragem() {
        return this.quilometragem;
    }

    public VeiculoModel getVeiculo() {
        return this.veiculo;
    }

    public UserModel getMotorista() {
        return this.motorista;
    }

    public void setId(Long value) {
        this.id = value;
    }

    public void setData(String value) {
        this.data = value;
    }

    public void setValor(Double value) {
        this.valor = value;
    }

    public void setQuilometragem(Double value) {
        this.quilometragem = value;
    }

    public void setVeiculo(VeiculoModel value) {
        this.veiculo = value;
    }

    public void setMotorista(UserModel value) {
        this.motorista = value;
    } 
    
    public void setTipoCombustivel (TipoCombustivelEnum value) {
        this.tipoCombustivel = value;
    }
}
