package com.ufpr.frotas.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ufpr.frotas.application.dto.AbastecimentoRequestDTO;
import com.ufpr.frotas.application.dto.AbastecimentoResponseDTO;
import com.ufpr.frotas.domain.model.AbastecimentoModel;
import com.ufpr.frotas.domain.repository.AbastecimentoRepository;
import com.ufpr.frotas.domain.repository.ManutencaoRepository;
import com.ufpr.frotas.web.mapper.AbastecimentoMapper;

@Service
public class AbastecimentoService {

    private final ManutencaoRepository manutencaoRepository;
    private final AbastecimentoRepository abastecimentoRepository;

    private final AbastecimentoMapper abastecimentoMapper;

    public AbastecimentoService(AbastecimentoRepository repo, AbastecimentoMapper mapper, ManutencaoRepository manutencaoRepository) {
        this.abastecimentoRepository = repo;
        this.abastecimentoMapper = mapper;
        this.manutencaoRepository = manutencaoRepository;
    }

    public AbastecimentoResponseDTO cadastrar(AbastecimentoRequestDTO dto) {

        AbastecimentoModel entity = abastecimentoMapper.toEntity(dto);

        entity.setData(dto.getData());
        entity.setValor(dto.getValor());
        entity.setQuilometragem(dto.getQuilometragem());
        entity.setMotorista(dto.getMotorista());
        entity.setVeiculo(dto.getVeiculo());
        entity.setTipoCombustivel(entity.getTipoCombustivel());

        return abastecimentoMapper.toDTO(abastecimentoRepository.save(entity));
    }

    public List<AbastecimentoResponseDTO> listarTodos() {
        return abastecimentoRepository.findAll().stream().map(abastecimentoMapper::toDTO).toList();
    }
}
