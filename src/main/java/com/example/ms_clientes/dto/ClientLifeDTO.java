package com.example.ms_clientes.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ClientLifeDTO {
    private Long id;
    private String name;
    private String lastname;
    private Integer age;
    private LocalDate birthdate;
    private LocalDate estimatedLifeDate;
}
