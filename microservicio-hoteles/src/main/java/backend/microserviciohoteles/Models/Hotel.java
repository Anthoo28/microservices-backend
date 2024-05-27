package backend.microserviciohoteles.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "tb_hotel")
@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_hotel")
    private  Long id;

    private Boolean estado=true;

    @Column(name="Nombre_hotel")
    private String nombre;

    @Column(name="Direccion_hotel")
    private String direccion;

    private String categoria;

    private String imagen;

}
