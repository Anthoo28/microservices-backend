package backend.microserviciovuelos.Models.DTO;

import backend.microserviciovuelos.Models.Aeropuerto;
import backend.microserviciovuelos.Models.Vuelo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AeropuertoMapper {
    AeropuertoDto toAeropuertoDTO(Aeropuerto aeropuerto);
    Aeropuerto toAeropuerto(AeropuertoDto aeropuertoDto);
}
