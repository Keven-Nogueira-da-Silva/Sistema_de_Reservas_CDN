package com.example.Sistema_de_reservas.Repository;

import com.example.Sistema_de_reservas.Model.Reservas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

import java.util.List;

@Repository
public interface ReservasRepository extends JpaRepository<Reservas, Long> {

    List<Reservas> findByDataDaFesta(LocalDate dataDaFesta);

    boolean existsByDataDaFesta(LocalDate dataDaFesta);
    boolean existsByDataDaFestaAndIdNot(LocalDate dataDaFesta, Long id);

}
