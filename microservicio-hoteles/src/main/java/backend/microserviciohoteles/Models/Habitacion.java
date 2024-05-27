package backend.microserviciohoteles.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "tb_habitacion")
public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean estado=true;

    private String tipo_habitacion;

    @ManyToOne
    @JoinColumn(name = "ID_hotel")
    private Hotel hotel;

    private Integer cantidad_camas;

    private Integer cantidad_personas;

    private Double precio;

    private String imagen;

}
