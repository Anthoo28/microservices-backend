package backend.microserviciohoteles.Dao;

import backend.microserviciohoteles.Models.Habitacion;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface HabitacionDao extends CrudRepository<Habitacion, Long> {
    List<Habitacion> findByHotelId(Long id);

}
