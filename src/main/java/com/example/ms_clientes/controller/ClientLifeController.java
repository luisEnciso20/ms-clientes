package com.example.ms_clientes.controller;

import com.example.ms_clientes.dto.ClientLifeDTO;
import com.example.ms_clientes.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/life")
@RequiredArgsConstructor
public class ClientLifeController {

    private final ClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientLifeDTO>> getAllClients() {
        return ResponseEntity.ok(
                clientService.getAllClientsWithDerivedData()
        );
    }

}
