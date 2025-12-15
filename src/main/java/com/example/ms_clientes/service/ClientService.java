package com.example.ms_clientes.service;

import com.example.ms_clientes.dto.ClientAgeStatsDTO;
import com.example.ms_clientes.dto.ClientDTO;
import com.example.ms_clientes.dto.ClientLifeDTO;

import java.util.List;

public interface ClientService {
    ClientDTO registerClient(ClientDTO dto);
    ClientAgeStatsDTO getStadistics();
    List<ClientLifeDTO> getAllClientsWithDerivedData();
}
