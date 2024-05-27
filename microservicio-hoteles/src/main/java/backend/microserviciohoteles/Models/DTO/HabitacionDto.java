package backend.microserviciohoteles.Models.DTO;

import lombok.Data;

@Data
public class HabitacionDto {
    private Long id;
    private Long hotelId;
    private String tipo_habitacion;
    private Integer cantidad_camas;
    private Integer cantidad_personas;
    private String extras;
    private Double precio;
    private String imagen;
}
