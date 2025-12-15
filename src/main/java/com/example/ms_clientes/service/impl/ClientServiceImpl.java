package com.example.ms_clientes.service.impl;

import com.example.ms_clientes.dto.ClientDTO;
import com.example.ms_clientes.model.Client;
import com.example.ms_clientes.repository.ClientRepository;
import com.example.ms_clientes.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

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

}
