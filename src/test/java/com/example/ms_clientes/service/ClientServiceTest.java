package com.example.ms_clientes.service;

import com.example.ms_clientes.dto.ClientLifeDTO;
import com.example.ms_clientes.mapper.ClientMapper;
import com.example.ms_clientes.model.Client;
import com.example.ms_clientes.repository.ClientRepository;
import com.example.ms_clientes.service.impl.ClientServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private ClientMapper clientMapper;

    @InjectMocks
    private ClientServiceImpl clientService;

    @Test
    void shouldReturnAllClientsWithDerivedData() {
        Client client = new Client();
        client.setId(1L);

        ClientLifeDTO dto = ClientLifeDTO.builder()
                .id(1L)
                .build();

        when(clientRepository.findAll()).thenReturn(List.of(client));
        when(clientMapper.toDtoLife(client)).thenReturn(dto);

        List<ClientLifeDTO> result =
                clientService.getAllClientsWithDerivedData();

        assertThat(result).hasSize(1);
        verify(clientRepository).findAll();
        verify(clientMapper).toDtoLife(client);
    }

}