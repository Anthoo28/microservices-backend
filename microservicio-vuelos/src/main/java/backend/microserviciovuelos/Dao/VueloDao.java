package backend.microserviciovuelos.Dao;

import backend.microserviciovuelos.Models.Vuelo;
import org.springframework.data.repository.CrudRepository;

public interface VueloDao extends CrudRepository<Vuelo, Long> {
}
