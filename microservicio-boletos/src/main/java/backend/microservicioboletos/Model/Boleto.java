package backend.microservicioboletos.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "tb_boleto")
public class Boleto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeroBoleto;
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;
    private Long usuarioId;
    private Double precioFinal;
    private String estado;
    private String metodoPago;
    private boolean esIdaYVuelta;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "id_boleto")
    private List<DetalleBoleto> detallesBoleto;

    @Column(name = "id_vuelo", nullable = false)
    private Long idVuelo;

   }
