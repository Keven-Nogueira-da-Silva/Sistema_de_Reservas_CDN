package com.example.Sistema_de_reservas.dto;


import java.math.BigDecimal;
import java.time.LocalDate;


public record ReservasResponseDto(
        Long id,
        LocalDate dataDaFesta,
        String nomeDoCliente,
        String diaDaSemana,
        BigDecimal valorDoSinal,
        BigDecimal valorRestante

) {}
