package com.ufpr.frotas.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufpr.frotas.application.dto.VeiculoRequestDTO;
import com.ufpr.frotas.application.dto.VeiculoResponseDTO;
import com.ufpr.frotas.application.service.VeiculoService;
import com.ufpr.frotas.domain.model.enums.StatusVeiculoEnum;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/veiculos")

public class VeiculoController {
    
    @Autowired
    private VeiculoService veiculoService;

    @PostMapping("/create")
    public ResponseEntity<VeiculoResponseDTO> cadastrar(@RequestBody VeiculoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculoService.cadastrar(dto));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<VeiculoResponseDTO>> listarTodos() {
        return ResponseEntity.ok(veiculoService.listarTodos());
    }

    @GetMapping("/disponiveis")
    public ResponseEntity<List<VeiculoResponseDTO>> listarDisponiveis() {
        return ResponseEntity.ok(veiculoService.listarDisponiveis());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity <Optional<VeiculoResponseDTO>> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(veiculoService.buscarPorId(id));
    }

    @PutMapping("/put/{id}")
    public ResponseEntity <VeiculoResponseDTO> putVeiculo(@PathVariable Long id, @RequestBody VeiculoRequestDTO entity) {
        
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculoService.putVeiculo(id, entity));
    }

    @PatchMapping("/status/{id}")
    public ResponseEntity <VeiculoResponseDTO> setStatus(@PathVariable Long id, @RequestBody StatusVeiculoEnum status) {
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculoService.inativar(id, status));
    }
}
