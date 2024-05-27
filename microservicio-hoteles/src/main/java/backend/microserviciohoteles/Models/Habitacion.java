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
    @Column(name = "ID_habitacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean estado=true;

    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_hotel")
    @JsonBackReference
    private Hotel hotel;

    private String tipo_habitacion;

    private Integer cantidad_camas;

    private Integer cantidad_personas;

    private String extras;

    private Double precio;

    private String imagen;



}
