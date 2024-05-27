package backend.microserviciohoteles.Models.DTO;

import backend.microserviciohoteles.Models.Hotel;
import lombok.Data;

@Data
public class HabitacionDto {
    private Long id;
    private Boolean estado;
    private String tipo_habitacion;
    private Hotel hotel;
    private Integer cantidad_camas;
    private Integer cantidad_personas;
    private Double precio;
    private String imagen;

}
