package backend.microserviciousuarios.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
@Table(name="tb_user")
@Entity
public class Usuario implements Serializable {

    @Id
    @Column(name = "DNI", length = 8, unique = true)
    private Long id;

    private boolean estado=true;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Role> roles;

    @NotBlank
    private String nombre;

    @NotBlank
    @Column(name="Direccion")
    private String direccion;

    @NotBlank
    @Column(length = 9)
    private  String telefono;

    @NotBlank
    @Column(unique = true)
    private String username;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    @Column(name = "contraseña")
    private String password;


    private String imagen;


}
