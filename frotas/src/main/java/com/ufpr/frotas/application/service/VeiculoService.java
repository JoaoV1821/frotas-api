package com.ufpr.frotas.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ufpr.frotas.application.dto.VeiculoRequestDTO;
import com.ufpr.frotas.application.dto.VeiculoResponseDTO;
import com.ufpr.frotas.domain.model.VeiculoModel;
import com.ufpr.frotas.domain.model.enums.StatusVeiculoEnum;
import com.ufpr.frotas.domain.repository.VeiculoRepository;
import com.ufpr.frotas.web.mapper.VeiculoMapper;

@Service
public class VeiculoService {
    
    private final VeiculoRepository veiculoRepository;
    private final VeiculoMapper veiculoMapper;

    public VeiculoService(VeiculoRepository repo, VeiculoMapper mapper) {
        this.veiculoRepository = repo;
        this.veiculoMapper = mapper;
    }

    public VeiculoResponseDTO cadastrar(VeiculoRequestDTO dto) {
        VeiculoModel entity = veiculoMapper.toEntity(dto);
        entity.setStatus(StatusVeiculoEnum.DISPONIVEL);

        
        return veiculoMapper.toDTO(veiculoRepository.save(entity));
    }

    public List<VeiculoResponseDTO> listarDisponiveis() {
        return veiculoRepository.findByStatus(StatusVeiculoEnum.DISPONIVEL).stream()
            .map(veiculoMapper::toDTO)
            .toList();
    }

    public List<VeiculoResponseDTO> listarTodos() {
       return veiculoRepository.findAll().stream()
            .map(veiculoMapper::toDTO)
            .toList();
    }

    public Optional <VeiculoResponseDTO> buscarPorId(Long id) {
       return veiculoRepository.findById(id).map(veiculoMapper::toDTO);
    }
}
