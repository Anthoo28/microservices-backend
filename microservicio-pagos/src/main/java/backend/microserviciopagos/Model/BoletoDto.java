package backend.microserviciopagos.Model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BoletoDto {
    private Long id;
    private Double precioFinal;

}
