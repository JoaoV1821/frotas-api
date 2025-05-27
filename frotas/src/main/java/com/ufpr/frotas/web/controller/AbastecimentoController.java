package com.ufpr.frotas.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufpr.frotas.application.dto.AbastecimentoRequestDTO;
import com.ufpr.frotas.application.dto.AbastecimentoResponseDTO;
import com.ufpr.frotas.application.service.AbastecimentoService;

@RestController
@RequestMapping("/api/abastecimento")
public class AbastecimentoController {
    
    @Autowired
    private AbastecimentoService abastecimentoService;

    @PostMapping("/create")
    public ResponseEntity<AbastecimentoResponseDTO> cadastrar(@RequestBody AbastecimentoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(abastecimentoService.cadastrar(dto));
    }

    @GetMapping("/getAll")
    public ResponseEntity
    <List<AbastecimentoResponseDTO>> listaTodos() {
        return ResponseEntity.ok(abastecimentoService.listarTodos());
    }
}
