package com.ufpr.frotas.web.mapper;

import org.mapstruct.Mapper;

import com.ufpr.frotas.application.dto.ViagemRequestDTO;
import com.ufpr.frotas.application.dto.ViagemResponseDTO;
import com.ufpr.frotas.domain.model.ViagemModel;


@Mapper(componentModel = "spring", uses = {UserMapper.class, VeiculoMapper.class, AgendamentoMapper.class})
public interface ViagemMapper {
    ViagemResponseDTO toDTO(ViagemModel model);
    ViagemModel toEntity(ViagemRequestDTO dto); 
}
