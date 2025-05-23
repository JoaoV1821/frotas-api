package com.ufpr.frotas.web.mapper;

import org.mapstruct.Mapper;

import com.ufpr.frotas.application.dto.VeiculoRequestDTO;
import com.ufpr.frotas.application.dto.VeiculoResponseDTO;
import com.ufpr.frotas.domain.model.VeiculoModel;

@Mapper(componentModel = "spring")
public interface VeiculoMapper {    
    VeiculoResponseDTO toDTO(VeiculoModel model);
    VeiculoModel toEntity(VeiculoRequestDTO dto);
}
