package com.example.ms_clientes.controller;

import com.example.ms_clientes.dto.ClientDTO;
import com.example.ms_clientes.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody ClientDTO clientDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(clientService.registerClient(clientDTO));
    }

}
