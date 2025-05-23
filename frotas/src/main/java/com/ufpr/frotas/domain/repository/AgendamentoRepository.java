package com.ufpr.frotas.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufpr.frotas.domain.model.AgendamentoModel;
import com.ufpr.frotas.domain.model.enums.StatusAgendamentoEnum;


@Repository
public interface AgendamentoRepository extends JpaRepository<AgendamentoModel, Long> {
   
    List<AgendamentoModel> findByStatusAgenda(StatusAgendamentoEnum status);

    List<AgendamentoModel> findByMotoristaId(Long motoristaId);
    List<AgendamentoModel> findByVeiculoId(Long veiculoId);

    List<AgendamentoModel> findByDataSaidaBetween(String inicio, String fim);
}
