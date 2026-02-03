package com.example.Sistema_de_reservas.service;

import com.example.Sistema_de_reservas.Model.Reservas;
import com.example.Sistema_de_reservas.Repository.ReservasRepository;
import com.example.Sistema_de_reservas.dto.ReservasRequestDto;
import com.example.Sistema_de_reservas.dto.ReservasResponseDto;
import com.example.Sistema_de_reservas.exception.RecursoNaoEncontradoException;
import com.example.Sistema_de_reservas.mapper.ReservasMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservasService {

    private final ReservasRepository reservasRepository;
    private final ReservasMapper reservasMapper;

    public List<ReservasResponseDto> findAll() {
        return reservasRepository.findAll()
                .stream()
                .map(reservasMapper::toResponse)
                .toList();
    }

    public List<ReservasResponseDto> findByData(LocalDate dataDaFesta) {
        List<Reservas> reservas = reservasRepository.findByDataDaFesta(dataDaFesta);
        return reservas.stream()
                .map(reservasMapper::toResponse)
                .toList();
    }

    @Transactional
    public ReservasResponseDto create(ReservasRequestDto dto) {
        if (reservasRepository.existsByDataDaFesta(dto.dataDaFesta())) {
            throw new RecursoNaoEncontradoException("á existe uma reserva marcada para este horário!");
        }
        Reservas reservas = reservasMapper.toEntity(dto);
        reservasRepository.save(reservas);
        return reservasMapper.toResponse(reservas);
    }

    public ReservasResponseDto findById(Long id) {
        Reservas reservas = reservasRepository.findById(id)
                .orElseThrow(()-> new RecursoNaoEncontradoException("Reserva não encontrada"));
        return reservasMapper.toResponse(reservas);
    }

    @Transactional
    public ReservasResponseDto update(Long id, ReservasRequestDto dto) {

        Reservas reservas = reservasRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException(
                        "Reserva não encontrada"
                ));

        if (reservasRepository.existsByDataDaFestaAndIdNot(dto.dataDaFesta(), id)) {
            throw new RecursoNaoEncontradoException(
                    "Já existe uma reserva marcada para esta data!"
            );
        }

        reservasMapper.updateEntity(dto, reservas);
        reservasRepository.save(reservas);

        return reservasMapper.toResponse(reservas);
    }


    @Transactional
    public void delete(Long id) {
        Reservas reservas = reservasRepository.findById(id)
                .orElseThrow(()-> new RecursoNaoEncontradoException("Usuario não encontrado"));
        reservasRepository.delete(reservas);
    }

}
