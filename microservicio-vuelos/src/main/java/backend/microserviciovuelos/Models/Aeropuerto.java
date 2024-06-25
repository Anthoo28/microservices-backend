package backend.microserviciovuelos.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name="tb_aeropuerto")
public class Aeropuerto {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_aeropuerto")
        private Integer id;

        private String nombre_aeropuerto;
        private String codigo_IATA;
        private String latitud;
        private Long id_ciudad;
        private  String longitud;


}
