package com.ufpr.frotas.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufpr.frotas.application.dto.OcorrenciaRequestDTO;
import com.ufpr.frotas.application.dto.OcorrenciaResponseDTO;
import com.ufpr.frotas.application.service.ManutencaoService;
import com.ufpr.frotas.application.service.OcorrenciaService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/ocorrencia")
public class OcorrenciaController {

    private final ManutencaoService manutencaoService;
    @Autowired
    private OcorrenciaService ocorrenciaService;

    OcorrenciaController(ManutencaoService manutencaoService) {
        this.manutencaoService = manutencaoService;
    }

    @PostMapping("/create")
    public ResponseEntity<OcorrenciaResponseDTO> cadastrar(@RequestBody OcorrenciaRequestDTO dto)  {
        return ResponseEntity.status(HttpStatus.CREATED).body(ocorrenciaService.cadastrar(dto));
    }

    @GetMapping("/getAll") 
    public ResponseEntity <List<OcorrenciaResponseDTO>> listarTodos() {
        return ResponseEntity.ok(ocorrenciaService.listarTodos());
    }

    
}
