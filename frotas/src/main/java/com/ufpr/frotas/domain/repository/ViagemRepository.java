package com.ufpr.frotas.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufpr.frotas.domain.model.ViagemModel;

@Repository
public interface ViagemRepository extends JpaRepository<ViagemModel, Long> {

    Optional<ViagemModel> findByAgendamentoId(Long agendamentoId);

    List<ViagemModel> findByDataInicioBetween(String inicio, String fim);
}
