package com.ufpr.frotas.web.mapper;

import org.mapstruct.Mapper;

import com.ufpr.frotas.application.dto.OcorrenciaRequestDTO;
import com.ufpr.frotas.application.dto.OcorrenciaResponseDTO;
import com.ufpr.frotas.domain.model.OcorrenciaModel;

@Mapper(componentModel = "spring", uses = {UserMapper.class, VeiculoMapper.class} )
public interface OcorrenciaMapper {
    OcorrenciaResponseDTO toDTO(OcorrenciaModel model);
    OcorrenciaModel toEntity(OcorrenciaRequestDTO dto);
}
