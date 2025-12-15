package com.example.ms_clientes.mapper;

import com.example.ms_clientes.model.Client;
import com.example.ms_clientes.dto.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ClientMapperTest {

    private final ClientMapper clientMapper = new ClientMapper();

    @Test
    void shouldCalculateEstimatedLifeDate() {
        Client client = new Client();
        client.setId(1L);
        client.setName("Luis");
        client.setLastname("Enciso");
        client.setAge(30);
        client.setBirthdate(LocalDate.of(1995, 5, 5));

        ClientLifeDTO dto = clientMapper.toDtoLife(client);

        assertThat(dto.getEstimatedLifeDate())
                .isEqualTo(LocalDate.of(2070, 5, 5));

    }

}