package com.example.Sistema_de_reservas.mapper;


import com.example.Sistema_de_reservas.Model.Reservas;
import com.example.Sistema_de_reservas.dto.ReservasRequestDto;
import com.example.Sistema_de_reservas.dto.ReservasResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ReservasMapper {

    ReservasResponseDto toResponse(Reservas reservas);

    @Mapping(target = "id", ignore = true)
    Reservas toEntity(ReservasRequestDto reservasRequestDto);

    @Mapping(target = "id", ignore = true)
    void updateEntity(ReservasRequestDto reservasRequestDto,
                      @MappingTarget Reservas reservas);
}
