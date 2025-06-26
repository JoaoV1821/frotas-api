package com.ufpr.frotas.application.service;

import java.util.List;

import com.ufpr.frotas.domain.repository.UserRepository;
import com.ufpr.frotas.domain.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import com.ufpr.frotas.application.dto.OcorrenciaRequestDTO;
import com.ufpr.frotas.application.dto.OcorrenciaResponseDTO;
import com.ufpr.frotas.domain.model.OcorrenciaModel;
import com.ufpr.frotas.domain.repository.OcorrenciaRepository;
import com.ufpr.frotas.web.mapper.OcorrenciaMapper;

@Service
public class OcorrenciaService {
    
    private final OcorrenciaRepository ocorrenciaRepository;
    private final OcorrenciaMapper ocorrenciaMapper;
    private final UserRepository userRepository;
    private final VeiculoRepository veiculoRepository;

    public OcorrenciaService(OcorrenciaRepository repo, OcorrenciaMapper mapper, UserRepository userRepository, VeiculoRepository veiculoRepository) {
        this.ocorrenciaRepository = repo;
        this.ocorrenciaMapper = mapper;
        this.userRepository = userRepository;
        this.veiculoRepository = veiculoRepository;
    }

    public OcorrenciaResponseDTO cadastrar(OcorrenciaRequestDTO dto) {
        OcorrenciaModel entity = new OcorrenciaModel();
        entity.setDescricao(dto.getDescricao());
        entity.setDataRegistro(dto.getDataRegistro());

        entity.setMotorista(userRepository.findById(dto.getMotoristaId())
                .orElseThrow(() -> new RuntimeException("Motorista não encontrado")));

        entity.setVeiculo(veiculoRepository.findById(dto.getVeiculoId())
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado")));

        return ocorrenciaMapper.toDTO(ocorrenciaRepository.save(entity));
    }

    public List<OcorrenciaResponseDTO> listarTodos() {
        return ocorrenciaRepository.findAll().stream().map(ocorrenciaMapper::toDTO).toList();
    }
    
}
