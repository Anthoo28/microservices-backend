package backend.microserviciovuelos.Models.DTO;

import backend.microserviciovuelos.Models.Aeropuerto;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
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


