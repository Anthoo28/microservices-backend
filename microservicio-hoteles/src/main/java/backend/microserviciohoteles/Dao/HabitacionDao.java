package backend.microserviciohoteles.Dao;

import backend.microserviciohoteles.Models.Habitacion;
import org.springframework.data.repository.CrudRepository;

public interface HabitacionDao extends CrudRepository<Habitacion, Long> {
}
