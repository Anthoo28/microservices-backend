package backend.microserviciooauth.model;

import jakarta.persistence.*;

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

@Entity
public class Usuario implements Serializable {

    @Id
    @Column(name = "DNI", length = 8, unique = true)
    private Long id;

    private boolean estado=true;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Role> roles;

    private String nombre;

    @Column(name="Direccion")
    private String direccion;

    @Column(length = 9)
    private  String telefono;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    @Column(name = "contraseña")
    private String password;

    private String imagen;


}
