package backend.microserviciousuarios.Dao;

import backend.microserviciousuarios.Model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDao  extends CrudRepository<Usuario, Long>{
}
