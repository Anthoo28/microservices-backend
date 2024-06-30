package backend.microservicioboletos.Model.Dto;

import backend.microservicioboletos.Model.Boleto;
import backend.microservicioboletos.Model.CategoriaViaje;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Component
public class DetalleBoletoDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreCompleto;
    private String dni;
    private String asiento;
    private CategoriaViaje categoriaViaje;
    private boolean esIda;
    private Double precioUnitario;
}
