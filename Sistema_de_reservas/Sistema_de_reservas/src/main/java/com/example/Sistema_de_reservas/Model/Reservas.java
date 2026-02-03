package com.example.Sistema_de_reservas.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "reservas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Data_da_festa", nullable = false)
    private LocalDate dataDaFesta;

    @Column(name = "Nome_do_cliente", nullable = false)
    private String nomeDoCliente;

    @Column(name = "Dia_da_semana", nullable = false)
    private String diaDaSemana;

    @Column(name = "Valor_do_sinal", nullable = false)
    private BigDecimal valorDoSinal;

    @Column(name = "Valor_Restante", nullable = false)
    private BigDecimal valorRestante;
}
