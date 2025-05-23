package com.ufpr.frotas.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufpr.frotas.application.dto.ViagemRequestDTO;
import com.ufpr.frotas.application.dto.ViagemResponseDTO;
import com.ufpr.frotas.application.service.ViagemService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/viagens")
@RequiredArgsConstructor
public class ViagemController {

    @Autowired
    private ViagemService viagemService;

    @PostMapping("/create")
    public ResponseEntity<ViagemResponseDTO> iniciar(@RequestBody ViagemRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(viagemService.iniciarViagem(dto));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity <Optional<ViagemResponseDTO>>buscar(@PathVariable Long id) {
        return ResponseEntity.ok(viagemService.buscarPorId(id));
    }

    @GetMapping("/get")
    public ResponseEntity<List<ViagemResponseDTO>> listarTodas() {
        return ResponseEntity.ok(viagemService.listarTodas());
    }
}
