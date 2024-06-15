package backend.microserviciohoteles.Models.DTO;

import backend.microserviciohoteles.Models.Hotel;
import jakarta.persistence.JoinColumn;
import lombok.Data;

@Data
public class HabitacionDto {
    private Long id;
    private Boolean estado=true;
    private String tipo_habitacion;
    @JoinColumn(name = "ID_hotel")
    private HotelDto  hotel;
    private Integer cantidad_camas;
    private Integer cantidad_personas;
    private Double precio;
    private String imagen;

}
