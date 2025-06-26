package com.ufpr.frotas.application.service;

import java.util.List;

import com.ufpr.frotas.domain.model.VeiculoModel;
import com.ufpr.frotas.domain.repository.VeiculoRepository;
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
    private final VeiculoRepository veiculoRepository;
    
    public ManutencaoService(ManutencaoRepository repo, ManutencaoMapper mapper, VeiculoRepository veiculoRepository) {
        this.manutencaoRepository = repo;
        this.manutencaoMapper = mapper;
        this.veiculoRepository = veiculoRepository;
    }

    public ManuntecaoResponseDTO cadastrar(ManutencaoRequestDTO dto) {
        ManutencaoModel model = new ManutencaoModel();

        model.setData(dto.getData());
        model.setDescricao(dto.getDescricao());
        model.setQuilometragem(dto.getQuilometragem());
        model.setTipo(dto.getTipo());
        model.setValor(dto.getValor());

        VeiculoModel veiculo = veiculoRepository.findById(dto.getVeiculo())
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado com ID: " + dto.getVeiculo()));

        model.setVeiculo(veiculo);

        ManutencaoModel salvo = manutencaoRepository.save(model);

        return manutencaoMapper.toDTO(salvo);
    }

    public List<ManuntecaoResponseDTO> listarTodos() {
        return manutencaoRepository.findAll().stream().map(manutencaoMapper::toDTO)
        .toList();
    }

    public void deletar(Long id) {
    ManutencaoModel entity = manutencaoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Manutenção não encontrada"));
        manutencaoRepository.delete(entity);
    }

    public ManuntecaoResponseDTO atualizar(ManutencaoRequestDTO dto) {
        ManutencaoModel entity = manutencaoRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Manutenção não encontrada"));

        entity.setData(dto.getData());
        entity.setDescricao(dto.getDescricao());
        entity.setQuilometragem(dto.getQuilometragem());
        entity.setTipo(dto.getTipo());
        entity.setValor(dto.getValor());

        VeiculoModel veiculo = veiculoRepository.findById(dto.getVeiculo())
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado com ID: " + dto.getVeiculo()));

        entity.setVeiculo(veiculo);

        return manutencaoMapper.toDTO(manutencaoRepository.save(entity));
    }

}
