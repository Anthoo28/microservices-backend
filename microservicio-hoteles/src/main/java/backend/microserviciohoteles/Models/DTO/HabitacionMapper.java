package backend.microserviciohoteles.Models.DTO;

import backend.microserviciohoteles.Models.Habitacion;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface HabitacionMapper {

    HabitacionMapper INSTANCE = Mappers.getMapper(HabitacionMapper.class);

    public HabitacionDto toHabitacionDto(Habitacion habitacion);

    public Habitacion toHabitacion(HabitacionDto habitacionDto);
}
