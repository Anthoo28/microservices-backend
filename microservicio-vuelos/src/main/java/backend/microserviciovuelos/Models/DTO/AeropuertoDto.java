package backend.microserviciovuelos.Models.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AeropuertoDto {
    private Integer id;
    private String nombre_aeropuerto;
    private String codigo_IATA;
    private String latitud;
    private String longitud;
    private Long id_ciudad;
}
