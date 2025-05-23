package com.ufpr.frotas.domain.model;

import com.ufpr.frotas.domain.model.enums.ManutencaoEnum;

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
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "manutencoes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManutencaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String data;

    @Enumerated(EnumType.STRING)
    private ManutencaoEnum tipo;

    private String descricao;
    private Double valor;
    private Double quilometragem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "veiculo_id", nullable = false)
    private VeiculoModel veiculo;

}
