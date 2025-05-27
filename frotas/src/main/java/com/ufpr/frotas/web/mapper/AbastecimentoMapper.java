package com.ufpr.frotas.web.mapper;

import org.mapstruct.Mapper;

import com.ufpr.frotas.application.dto.AbastecimentoRequestDTO;
import com.ufpr.frotas.application.dto.AbastecimentoResponseDTO;

import com.ufpr.frotas.domain.model.AbastecimentoModel;



@Mapper(componentModel = "spring", uses ={VeiculoMapper.class, UserMapper.class})
public interface AbastecimentoMapper {
    AbastecimentoResponseDTO toDTO(AbastecimentoModel model);
    AbastecimentoModel toEntity(AbastecimentoRequestDTO dto);
}
