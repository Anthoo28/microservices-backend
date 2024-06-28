package backend.microservicioboletos.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CategoriaViaje {
    ECONOMICO(0.0),
    EJECUTIVO(100.0),
    PRIMERA_CLASE(200.0);

    private final double adicional;

}
