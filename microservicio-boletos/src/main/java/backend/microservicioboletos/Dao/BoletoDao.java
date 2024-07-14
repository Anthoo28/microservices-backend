package backend.microservicioboletos.Dao;

import backend.microservicioboletos.Model.Boleto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoletoDao extends JpaRepository<Boleto, Long> {
}
