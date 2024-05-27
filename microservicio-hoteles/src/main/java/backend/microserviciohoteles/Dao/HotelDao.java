package backend.microserviciohoteles.Dao;

import backend.microserviciohoteles.Models.Hotel;
import org.springframework.data.repository.CrudRepository;

public interface HotelDao extends CrudRepository<Hotel,Long> {
}
