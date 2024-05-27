package backend.microserviciohoteles.Models.DTO;

import backend.microserviciohoteles.Models.Habitacion;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HabitacionMapper {
    public HabitacionDto toHabitacionDto(Habitacion habitacion);

    public Habitacion toHabitacion(HabitacionDto habitacionDto);
}
