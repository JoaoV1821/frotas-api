package com.ufpr.frotas.web.mapper;

import org.mapstruct.Mapper;

import com.ufpr.frotas.application.dto.UserRequestDTO;
import com.ufpr.frotas.application.dto.UserResponseDTO;
import com.ufpr.frotas.domain.model.UserModel;

@Mapper(componentModel = "spring",  uses = {EnderecoMapper.class})
public interface UserMapper {
    UserResponseDTO toDTO(UserModel model);
    UserModel toEntity(UserRequestDTO dto);  
} 
