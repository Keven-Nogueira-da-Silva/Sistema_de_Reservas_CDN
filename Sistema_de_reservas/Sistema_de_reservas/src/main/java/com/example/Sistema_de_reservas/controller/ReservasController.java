package com.example.Sistema_de_reservas.controller;

import com.example.Sistema_de_reservas.dto.ReservasRequestDto;
import com.example.Sistema_de_reservas.dto.ReservasResponseDto;
import com.example.Sistema_de_reservas.service.ReservasService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/reservas")
@RequiredArgsConstructor
public class ReservasController {

    private final ReservasService reservasService;

    @GetMapping
    public List<ReservasResponseDto> findAll() {
        return reservasService.findAll();
    }

    @GetMapping("/buscar")
    public List<ReservasResponseDto> findByData(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate data) {
        return reservasService.findByData(data);
    }

    @PostMapping
    public ReservasResponseDto create(@RequestBody ReservasRequestDto dto) {
        return reservasService.create(dto);
    }

    @GetMapping("/{id}")
    public ReservasResponseDto findById(@PathVariable Long id) {
        return reservasService.findById(id);
    }

    @PutMapping("/{id}")
    public ReservasResponseDto update(@PathVariable Long id,
                                      @RequestBody ReservasRequestDto dto) {
        return reservasService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public  void delete(@PathVariable Long id) {
        reservasService.delete(id);
    }
}
