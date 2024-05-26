package backend.microserviciousuarios.Service;

import backend.microserviciousuarios.Model.DTO.UsuarioDto;
import backend.microserviciousuarios.Model.Usuario;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface IUsuarioService {

    public List<UsuarioDto> findAll();

    public UsuarioDto findById(Long id);


    public UsuarioDto save(UsuarioDto usuarioDto);


    public void deleteById(Long id);

}
