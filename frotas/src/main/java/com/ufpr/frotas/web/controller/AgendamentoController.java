package com.ufpr.frotas.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ufpr.frotas.application.dto.AgendamentoRequestDTO;
import com.ufpr.frotas.application.dto.AgendamentoResponseDTO;
import com.ufpr.frotas.application.service.AgendamentoService;


@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @PostMapping("/create")
    public ResponseEntity<AgendamentoResponseDTO> agendar(@RequestBody AgendamentoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(agendamentoService.criar(dto));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity <Optional <AgendamentoResponseDTO>> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(agendamentoService.buscarPorId(id));
    }

    @GetMapping("/getAllMotorista/{id}")
    public ResponseEntity<List<AgendamentoResponseDTO>> listarPorMotorista(@PathVariable Long id) {
        return ResponseEntity.ok(agendamentoService.buscarPorMotorista(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AgendamentoResponseDTO>> listarTodos() {
        return ResponseEntity.ok(agendamentoService.listarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgendamentoResponseDTO> atualizar(@PathVariable Long id, @RequestBody AgendamentoRequestDTO dto) {
        return ResponseEntity.ok(agendamentoService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        agendamentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
