package com.ufpr.frotas.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufpr.frotas.domain.model.VeiculoModel;
import com.ufpr.frotas.domain.model.enums.StatusVeiculoEnum;

@Repository
public interface VeiculoRepository extends JpaRepository<VeiculoModel, Long> {
    Optional<VeiculoModel> findByPlaca(String placa);

     List<VeiculoModel> findByStatus(StatusVeiculoEnum status);

     Optional <VeiculoModel> findVeiculoById(Long Id);
}
