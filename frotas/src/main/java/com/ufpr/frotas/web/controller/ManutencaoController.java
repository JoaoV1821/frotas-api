package com.ufpr.frotas.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufpr.frotas.application.dto.ManuntecaoResponseDTO;
import com.ufpr.frotas.application.dto.ManutencaoRequestDTO;
import com.ufpr.frotas.application.service.ManutencaoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/manutencao")
public class ManutencaoController {
    
    @Autowired
    private ManutencaoService manutencaoService;

    @PostMapping("/create")
    public ResponseEntity<ManuntecaoResponseDTO> cadastrar(@RequestBody ManutencaoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(manutencaoService.cadastrar(dto));
    }

    @GetMapping("/getAll")
    public ResponseEntity <List<ManuntecaoResponseDTO>> listarTodos() {
        return ResponseEntity.ok(manutencaoService.listarTodos());
    }
    
}
