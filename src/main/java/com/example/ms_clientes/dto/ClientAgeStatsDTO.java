package com.example.ms_clientes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientAgeStatsDTO {
    private Double averageAge;
    private Double standardDeviation;
}