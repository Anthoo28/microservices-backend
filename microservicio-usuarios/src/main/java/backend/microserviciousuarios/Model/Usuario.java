package backend.microserviciousuarios.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
@Table(name="tb_user")
@Entity
public class Usuario {

    @Id
    @Column(name = "DNI", length = 8, unique = true)
    private Long id;

    private boolean estado;


    @NotBlank
    private String nombre;

    @NotBlank
    @Column(name="Direccion")
    private String direccion;

    @NotBlank
    @Column(length = 9)
    private  String telefono;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    private String contraseña;

    private String imagen;


}
