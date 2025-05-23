package com.ufpr.frotas.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufpr.frotas.domain.model.OcorrenciaModel;


@Repository
public interface OcorrenciaRepository extends JpaRepository<OcorrenciaModel, Long> {
    List<OcorrenciaModel> findByVeiculoId(Long veiculoId);

     List<OcorrenciaModel> findByMotoristaId(Long motoristaId);
}
