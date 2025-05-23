package com.ufpr.frotas.web.mapper;

import org.mapstruct.Mapper;

import com.ufpr.frotas.application.dto.AgendamentoRequestDTO;
import com.ufpr.frotas.application.dto.AgendamentoResponseDTO;
import com.ufpr.frotas.domain.model.AgendamentoModel;


@Mapper(componentModel = "spring", uses = VeiculoMapper.class)
public interface AgendamentoMapper {
    AgendamentoResponseDTO toDTO(AgendamentoModel model);
    AgendamentoModel toEntity(AgendamentoRequestDTO dto);
}
