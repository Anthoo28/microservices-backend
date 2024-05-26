package backend.microserviciousuarios.Service;

import backend.microserviciousuarios.Dao.UsuarioDao;
import backend.microserviciousuarios.Model.DTO.UsuarioDto;
import backend.microserviciousuarios.Model.DTO.UsuarioMapper;
import backend.microserviciousuarios.Model.Usuario;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioSerivceImpl implements  IUsuarioService{

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioDto> findAll() {
        List<Usuario> usuarios = (List<Usuario>) usuarioDao.findAll();
      return usuarios.stream()
              .map(usuarioMapper::toDTO)
              .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioDto findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("id no puede ser nulo");
        }
        return usuarioDao.findById(id)
                .map(usuarioMapper::toDTO)
                .orElse(null);
    }


    @Override
    public UsuarioDto save(UsuarioDto usuarioDto) {
        Usuario usuario = usuarioMapper.toEntity(usuarioDto);
        Usuario savedUsuario = usuarioDao.save(usuario);
        return usuarioMapper.toDTO(savedUsuario);
    }



    @Override
    public void deleteById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("id no puede ser nulo");
        }
        Usuario usuario= usuarioDao.findById(id).orElse(null);
       if (usuario != null){
           usuario.setEstado(false);
           usuarioDao.save(usuario);
       }
    }
}
