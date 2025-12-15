package com.example.ms_clientes.service.impl;

import com.example.ms_clientes.dto.ClientAgeStatsDTO;
import com.example.ms_clientes.dto.ClientDTO;
import com.example.ms_clientes.dto.ClientLifeDTO;
import com.example.ms_clientes.mapper.ClientMapper;
import com.example.ms_clientes.model.Client;
import com.example.ms_clientes.repository.ClientRepository;
import com.example.ms_clientes.repository.ClientRepositoryCustom;
import com.example.ms_clientes.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    private final ClientRepositoryCustom clientRepositoryCustom;

    private final ClientMapper clientMapper;

    public ClientDTO registerClient(ClientDTO dto) {

        Client client = Client.builder()
                .name(dto.getName())
                .lastname(dto.getLastname())
                .age(dto.getAge())
                .birthdate(dto.getBirthdate())
                .build();

        Client saved =clientRepository.save(client);

        ClientDTO response = ClientDTO.builder()
                .id(saved.getId())
                .name(saved.getName())
                .lastname(saved.getLastname())
                .age(saved.getAge())
                .birthdate(saved.getBirthdate())
                .build();
        return response;
    }

    public ClientAgeStatsDTO getStadistics() {
        return clientRepositoryCustom.getAgeStatistics();
    }

    public List<ClientLifeDTO> getAllClientsWithDerivedData() {

        return clientRepository.findAll()
                .stream()
                .map(clientMapper::toDtoLife)
                .toList();
    }
}
