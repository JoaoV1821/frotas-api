package com.ufpr.frotas.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufpr.frotas.domain.model.AbastecimentoModel;

@Repository
public interface AbastecimentoRepository extends JpaRepository<AbastecimentoModel, Long> {
    List<AbastecimentoModel> findByVeiculoId(Long id);

    List<AbastecimentoModel> findByMotoristaId(Long id);
}
