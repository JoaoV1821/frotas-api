package com.ufpr.frotas.domain.repository;

import com.ufpr.frotas.domain.model.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EnderecoRepository extends JpaRepository<EnderecoModel, Long> {

    Optional<EnderecoModel> findById(Long id);
    List<EnderecoModel> findByCidade(String cidade);
    List<EnderecoModel> findByEstado(String estado);
    List<EnderecoModel> findByCep(String cep);
}
