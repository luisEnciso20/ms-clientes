package com.example.ms_clientes.repository;

import com.example.ms_clientes.dto.ClientAgeStatsDTO;

public interface ClientRepositoryCustom {
    ClientAgeStatsDTO getAgeStatistics();
}
