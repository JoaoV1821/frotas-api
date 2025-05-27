package com.ufpr.frotas.web.mapper;

import org.mapstruct.Mapper;

import com.ufpr.frotas.application.dto.ManuntecaoResponseDTO;
import com.ufpr.frotas.application.dto.ManutencaoRequestDTO;
import com.ufpr.frotas.domain.model.ManutencaoModel;

@Mapper(componentModel = "spring", uses = {VeiculoMapper.class})

public interface ManutencaoMapper {
    ManuntecaoResponseDTO toDTO(ManutencaoModel model);
    ManutencaoModel toEntity(ManutencaoRequestDTO dto);
}
