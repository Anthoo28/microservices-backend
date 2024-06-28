package backend.microservicioboletos.Dao;

import backend.microservicioboletos.Model.Boleto;
import org.springframework.data.repository.CrudRepository;

public interface BoletoDao extends CrudRepository<Boleto, Long> {
}
