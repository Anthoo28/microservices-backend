package backend.microserviciovuelos.Dao;

import backend.microserviciovuelos.Models.Vuelo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface VueloDao extends CrudRepository<Vuelo, Long> {
    @Query("SELECT v fROM Vuelo v WHERE v.fechaSalida =:fecha")
    List<Vuelo> findByFecha(@Param("fecha") LocalDate fecha);

}
