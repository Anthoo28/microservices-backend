package backend.microserviciovuelos.Dao;

import backend.microserviciovuelos.Models.Aeropuerto;
import org.springframework.data.repository.CrudRepository;

public interface AeropuertoDao extends CrudRepository<Aeropuerto, Integer> {
}
