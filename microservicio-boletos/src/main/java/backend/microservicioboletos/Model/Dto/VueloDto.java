package backend.microservicioboletos.Model.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class VueloDto {
    private Long id;

    private String numeroVuelo;
    private Long aeropuertoOrigenId;
    private Long aeropuertoLlegadaId;
    private LocalDate fechaSalida;
    private String horaSalida;
    private String horaLlegada;
    private Integer duracion;
    private int asientosDisponibles;
    private String estado;
    private Double precio;
}
