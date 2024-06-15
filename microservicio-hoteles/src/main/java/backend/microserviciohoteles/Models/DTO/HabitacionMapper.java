package backend.microserviciohoteles.Models.DTO;

import backend.microserviciohoteles.Models.Habitacion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",  uses = HotelMapper.class)// Assuming you have a HotelMapper
public interface HabitacionMapper {
    HabitacionDto toHabitacionDto(Habitacion habitacion);

    Habitacion toHabitacion(HabitacionDto habitacionDto);
}
