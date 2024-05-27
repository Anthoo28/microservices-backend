package backend.microserviciousuarios.Model.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UsuarioDto {

    @Id
    @Column(name = "DNI", length = 8, unique = true)
    private Long id;

    private boolean estado=true;

    private String nombre;

    private String direccion;

    private String telefono;

    @Email
    private String email;

    private String password;

    private String imagen;

}
