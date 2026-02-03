package com.example.Sistema_de_reservas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;


public record ReservasRequestDto(
        @NotNull
        LocalDate dataDaFesta,
        @NotBlank
        String nomeDoCliente,
        @NotBlank
        String diaDaSemana,
        @NotNull
        BigDecimal valorDoSinal,
        @NotNull
        BigDecimal valorRestante

) {
}
