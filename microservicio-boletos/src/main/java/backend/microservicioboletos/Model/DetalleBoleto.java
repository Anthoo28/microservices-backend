package backend.microservicioboletos.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "tb_detalle_boleto")
public class DetalleBoleto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreCompleto;
    private String dni;
    private String asiento;
    @Enumerated(EnumType.STRING)
    private CategoriaViaje categoriaViaje;
    private boolean esIda;
    private Double precioUnitario;
}
