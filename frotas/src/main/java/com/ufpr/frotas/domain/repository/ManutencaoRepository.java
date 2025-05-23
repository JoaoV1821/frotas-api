package com.ufpr.frotas.domain.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufpr.frotas.domain.model.ManutencaoModel;
import com.ufpr.frotas.domain.model.enums.ManutencaoEnum;


@Repository
public interface ManutencaoRepository extends JpaRepository<ManutencaoModel, Long>{ 
    List<ManutencaoModel> findByVeiculoId(Long veiculoId);

    List<ManutencaoModel> findByTipo(ManutencaoEnum tipo); // PREVENTIVA ou CORRETIVA

    List<ManutencaoModel> findByDataBetween(String inicio, String fim);
}
