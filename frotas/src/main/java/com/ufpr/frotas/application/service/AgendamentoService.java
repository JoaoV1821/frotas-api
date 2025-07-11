package com.ufpr.frotas.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ufpr.frotas.application.dto.AgendamentoRequestDTO;
import com.ufpr.frotas.application.dto.AgendamentoResponseDTO;
import com.ufpr.frotas.domain.model.AgendamentoModel;
import com.ufpr.frotas.domain.model.UserModel;
import com.ufpr.frotas.domain.model.VeiculoModel;
import com.ufpr.frotas.domain.model.enums.StatusAgendamentoEnum;
import com.ufpr.frotas.domain.model.enums.StatusVeiculoEnum;
import com.ufpr.frotas.domain.repository.AgendamentoRepository;
import com.ufpr.frotas.domain.repository.UserRepository;
import com.ufpr.frotas.domain.repository.VeiculoRepository;
import com.ufpr.frotas.web.mapper.AgendamentoMapper;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final AgendamentoMapper agendamentoMapper;
    private final VeiculoRepository veiculoRepository;
    private final UserRepository usuarioRepository;

    public AgendamentoService(AgendamentoRepository ar, AgendamentoMapper am, VeiculoRepository vr, UserRepository ur) {
        this.agendamentoRepository = ar;
        this.agendamentoMapper = am;
        this.veiculoRepository = vr;
        this.usuarioRepository = ur;
    }

    public AgendamentoResponseDTO criar(AgendamentoRequestDTO dto) {
        // Validar veículo e motorista
        VeiculoModel veiculo = veiculoRepository.findById(dto.getVeiculo().getId())
            .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));
        if (veiculo.getStatus() != StatusVeiculoEnum.DISPONIVEL)
            throw new RuntimeException("Veículo indisponível");

        UserModel motorista = usuarioRepository.findById(dto.getMotorista().getId())
            .orElseThrow(() -> new RuntimeException("Motorista não encontrado"));

        AgendamentoModel entity = agendamentoMapper.toEntity(dto);

        entity.setVeiculo(veiculo);
        entity.setMotorista(motorista);
        entity.setStatusAgenda(dto.getStatusAgenda());
        entity.setDataSaida(dto.getDataSaida());
        entity.setDataRetorno(dto.getDataRetorno());
        entity.setJustificativa(dto.getJustificativa());
        entity.setDestino(dto.getDestino());
        entity.setDataInicio(dto.getDataInicio());

        return agendamentoMapper.toDTO(agendamentoRepository.save(entity));
    }

    public List<AgendamentoResponseDTO> listarTodos() {
       return agendamentoRepository.findAll().stream()
        .map(agendamentoMapper::toDTO)
        .toList();
    }

    public Optional<AgendamentoResponseDTO> buscarPorId(Long id) {
        return agendamentoRepository.findById(id).map(agendamentoMapper::toDTO);
    }

    public List<AgendamentoResponseDTO> buscarPorMotorista(Long id) {
        return agendamentoRepository.findByMotoristaId(id).stream()
        .map(agendamentoMapper::toDTO)
        .toList();
    }

    public AgendamentoResponseDTO setStatus(Long id, StatusAgendamentoEnum status) {

      Optional <AgendamentoModel> agendamentoBd = Optional.of(agendamentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Agendamento não encontrado"))); 

       AgendamentoModel agendamento = agendamentoBd.get();

       agendamento.setStatusAgenda(status);

       agendamentoRepository.save(agendamento);

       return agendamentoMapper.toDTO(agendamento);
    }

    public AgendamentoResponseDTO atualizar(Long id, AgendamentoRequestDTO dto) {
    Optional<AgendamentoModel> agendamentoBd = agendamentoRepository.findById(id);
        if (agendamentoBd.isEmpty()) {
            throw new RuntimeException("Agendamento não encontrado");
        }

        AgendamentoModel agendamento = agendamentoBd.get();

        agendamento.setDataInicio(dto.getDataInicio());
        agendamento.setStatusAgenda(dto.getStatusAgenda());
        agendamento.setQuilometragemInicial(dto.getQuilometragemInicial());
        agendamento.setObservacaoInicio(dto.getObservacaoInicio());
        agendamento.setDataFim(dto.getDataFim());
        agendamento.setQuilometragemFinal(dto.getQuilometragemFinal());
        agendamento.setObservacaoFim(dto.getObservacaoFim());
        return agendamentoMapper.toDTO(agendamentoRepository.save(agendamento));
    }

    public void deletar(Long id) {
        if (!agendamentoRepository.existsById(id)) {
            throw new RuntimeException("Agendamento não encontrado");
        }
        agendamentoRepository.deleteById(id);
    }
}
