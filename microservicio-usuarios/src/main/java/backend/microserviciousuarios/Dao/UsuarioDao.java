package backend.microserviciousuarios.Dao;

import backend.microserviciousuarios.Model.Usuario;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path="usuarios")
public interface UsuarioDao  extends PagingAndSortingRepository<Usuario, Long> {

     @RestResource(path = "buscar-username")
     public Usuario findByUsername(String username);
}
