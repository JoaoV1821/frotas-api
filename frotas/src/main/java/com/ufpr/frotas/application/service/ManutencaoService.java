package com.ufpr.frotas.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ufpr.frotas.application.dto.ManuntecaoResponseDTO;
import com.ufpr.frotas.application.dto.ManutencaoRequestDTO;
import com.ufpr.frotas.domain.model.ManutencaoModel;
import com.ufpr.frotas.domain.repository.ManutencaoRepository;
import com.ufpr.frotas.web.mapper.ManutencaoMapper;

@Service
public class ManutencaoService {
    private final ManutencaoRepository manutencaoRepository;
    private final ManutencaoMapper manutencaoMapper;
    
    public ManutencaoService(ManutencaoRepository repo, ManutencaoMapper mapper) {
        this.manutencaoRepository = repo;
        this.manutencaoMapper = mapper;
    }

    public ManuntecaoResponseDTO cadastrar(ManutencaoRequestDTO dto) {
        ManutencaoModel entity = manutencaoMapper.toEntity(dto);

        entity.setData(dto.getData());
        entity.setDescricao(dto.getDescricao());
        entity.setQuilometragem(dto.getQuilometragem());
        entity.setTipo(dto.getTipo());
        entity.setValor(dto.getValor());
        entity.setVeiculo(dto.getVeiculo());

        return manutencaoMapper.toDTO(manutencaoRepository.save(entity));
        
    }

    public List<ManuntecaoResponseDTO> listarTodos() {
        return manutencaoRepository.findAll().stream().map(manutencaoMapper::toDTO)
        .toList();
    }
}
