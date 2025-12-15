package com.example.ms_clientes.controller;

import com.example.ms_clientes.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/report")
@RequiredArgsConstructor
public class ReportController {

    private final ClientService clientService;

    @GetMapping()
    public ResponseEntity<?> getStadistics(){
        return ResponseEntity.ok(clientService.getStadistics());
    }

}
