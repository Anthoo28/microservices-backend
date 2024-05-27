package backend.microserviciohoteles.Models.DTO;

import backend.microserviciohoteles.Models.Habitacion;
import lombok.Data;

import java.util.List;

@Data
public class HotelDto {
    private Long id;
    private Boolean estado;

    private String nombre;
    private String direccion;
    private String categoria;
    private String imagen;
    private List<Habitacion> habitaciones;
}
