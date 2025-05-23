package com.ufpr.frotas.web.mapper;

import org.mapstruct.Mapper;

import com.ufpr.frotas.application.dto.EnderecoRequestDTO;
import com.ufpr.frotas.domain.model.EnderecoModel;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {
    EnderecoRequestDTO toDTO(EnderecoModel model);
    EnderecoModel toEntity(EnderecoRequestDTO dto);
}
