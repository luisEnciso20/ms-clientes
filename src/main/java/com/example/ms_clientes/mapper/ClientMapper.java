package com.example.ms_clientes.mapper;

import com.example.ms_clientes.dto.ClientLifeDTO;
import com.example.ms_clientes.model.Client;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ClientMapper {

    private static final int LIFE_EXPECTANCY_YEARS = 75;

    public ClientLifeDTO toDtoLife(Client client) {
        LocalDate estimatedLifeDate = null;

        if (client.getBirthdate() != null) {
            estimatedLifeDate = client.getBirthdate()
                    .plusYears(LIFE_EXPECTANCY_YEARS);
        }

        return ClientLifeDTO.builder()
                .id(client.getId())
                .name(client.getName())
                .lastname(client.getLastname())
                .age(client.getAge())
                .birthdate(client.getBirthdate())
                .estimatedLifeDate(estimatedLifeDate)
                .build();
    }

}
