package com.ufpr.frotas.application.service;

import java.util.List;

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

    public OcorrenciaService(OcorrenciaRepository repo, OcorrenciaMapper mapper) {
        this.ocorrenciaRepository = repo;

        this.ocorrenciaMapper = mapper;
    }

    public OcorrenciaResponseDTO cadastrar(OcorrenciaRequestDTO dto) {
       OcorrenciaModel entity = ocorrenciaMapper.toEntity(dto);

        entity.setDescricao(dto.getDescricao());
        entity.setMotorista(dto.getMotorista());
        entity.setDataRegistro(dto.getDataRegistro());

        return ocorrenciaMapper.toDTO(ocorrenciaRepository.save(entity));
        
    }

    public List<OcorrenciaResponseDTO> listarTodos() {
        return ocorrenciaRepository.findAll().stream().map(ocorrenciaMapper::toDTO).toList();
    }
    
}
