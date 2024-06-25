package backend.microserviciovuelos.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name="tb_vuelo")
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroVuelo;


    @ManyToOne
    @JoinColumn(name = "id_aeropuerto_origen", updatable = false)
    private Aeropuerto aeropuertoOrigen;

    @ManyToOne
    @JoinColumn(name = "id_aeropuerto_llegada", updatable = false)
    private Aeropuerto aeropuertoLlegada;

    private LocalDate fechaSalida;

    private String horaSalida;

    private String horaLlegada;

    private Integer duracion;
    private int asientosDisponibles;

    private String estado;

    private Double precio;




}
