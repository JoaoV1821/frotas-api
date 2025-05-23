package com.ufpr.frotas.web.controller;

import java.util.List;

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

import com.ufpr.frotas.application.dto.UserRequestDTO;
import com.ufpr.frotas.application.dto.UserResponseDTO;
import com.ufpr.frotas.application.service.UserService;

import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/users")

public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserResponseDTO> criar(@RequestBody UserRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.criarUser(dto));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<UserResponseDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(userService.buscarPorId(id));
    }

    @GetMapping("/getAtivos")
    public ResponseEntity<List<UserResponseDTO>> listarMotoristas() {
        return ResponseEntity.ok(userService.listarMotoristasAtivos());
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<UserResponseDTO> putUser(@PathVariable Long id, @RequestBody UserRequestDTO entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.putUser(id, entity));
    }

    @PatchMapping("/inativar/{id}")
    public ResponseEntity <UserResponseDTO> inativar(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.inativar(id));
    }
}
