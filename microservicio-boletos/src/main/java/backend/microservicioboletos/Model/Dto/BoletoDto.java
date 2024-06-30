package backend.microservicioboletos.Model.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Component
public class BoletoDto {
    private Long id;
    private String numeroBoleto;
    private Date fechaEmision;
    private Long usuarioId;
    private Double precioFinal;
    private String estado;
    private String metodoPago;
    private boolean esIdaYVuelta;
    private Long idVuelo;
    private List<DetalleBoletoDto> detallesBoleto;
}

