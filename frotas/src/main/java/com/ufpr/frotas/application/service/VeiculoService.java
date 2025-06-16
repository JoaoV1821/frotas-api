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
        
        entity.setStatus(dto.getStatus());

        entity.setPlaca(dto.getPlaca());
        entity.setModelo(dto.getModelo());
        entity.setTipo(dto.getTipo());
        entity.setQuilometragemAtual(dto.getQuilometragemAtual());
        entity.setRenavam(dto.getRenavam());
        entity.setChassi(dto.getChassi());

        return veiculoMapper.toDTO(veiculoRepository.save(entity));
    }

    public VeiculoResponseDTO putVeiculo (Long id, VeiculoRequestDTO dto) {
        Optional <VeiculoModel> veiculoBd = Optional.of(veiculoRepository.findById(id).orElseThrow(() -> new RuntimeException("Veículo não encontrado")));

        VeiculoModel veiculo = veiculoBd.get();

        veiculo.setAno(dto.getAno());
        veiculo.setChassi(dto.getChassi());
        veiculo.setModelo(dto.getModelo());
        veiculo.setPlaca(dto.getPlaca());
        veiculo.setQuilometragemAtual(dto.getQuilometragemAtual());
        veiculo.setRenavam(dto.getRenavam());
        veiculo.setTipo(dto.getTipo());
        veiculo.setStatus(dto.getStatus());

        veiculoRepository.save(veiculo);

        return veiculoMapper.toDTO(veiculo);
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


    public VeiculoResponseDTO inativar(Long id, StatusVeiculoEnum status) {
         VeiculoModel veiculo = veiculoRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

         veiculo.setStatus(status);

         veiculoRepository.save(veiculo);

         return veiculoMapper.toDTO(veiculo);
     }

    public void deletar(Long id) {
        if (!veiculoRepository.existsById(id)) {
            throw new RuntimeException("Veículo não encontrado");
        }
        veiculoRepository.deleteById(id);
    }
}
