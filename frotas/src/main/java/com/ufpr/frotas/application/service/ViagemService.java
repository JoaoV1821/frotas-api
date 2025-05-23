package com.ufpr.frotas.application.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ufpr.frotas.application.dto.ViagemRequestDTO;
import com.ufpr.frotas.application.dto.ViagemResponseDTO;
import com.ufpr.frotas.domain.model.AgendamentoModel;
import com.ufpr.frotas.domain.model.ViagemModel;
import com.ufpr.frotas.domain.repository.AgendamentoRepository;
import com.ufpr.frotas.domain.repository.ViagemRepository;
import com.ufpr.frotas.web.mapper.ViagemMapper;

@Service
public class ViagemService {

    private final ViagemRepository viagemRepository;
    private final AgendamentoRepository agendamentoRepository;
    private final ViagemMapper viagemMapper;

    public ViagemService(ViagemRepository vr, AgendamentoRepository ar, ViagemMapper mapper) {
        this.viagemRepository = vr;
        this.agendamentoRepository = ar;
        this.viagemMapper = mapper;
    }

    public ViagemResponseDTO iniciarViagem(ViagemRequestDTO dto) {
        
        AgendamentoModel agendamento = agendamentoRepository.findById(dto.getAgendamento().getId())
            .orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));

        ViagemModel viagem = viagemMapper.toEntity(dto);

        viagem.setAgendamento(agendamento);
        viagem.setDataInicio(LocalDateTime.now().toString());

        return viagemMapper.toDTO(viagemRepository.save(viagem));
    }

    public Optional<ViagemResponseDTO> buscarPorId(Long id) {
        return viagemRepository.findById(id).map(viagemMapper::toDTO);
    }

    public List<ViagemResponseDTO> listarTodas() {
       return viagemRepository.findAll().stream().map(viagemMapper::toDTO).toList();
    }
}