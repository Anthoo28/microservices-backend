package backend.microserviciousuarios.Model.DTO;

import backend.microserviciousuarios.Model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);
    UsuarioDto toDTO(Usuario usuario);

    Usuario toEntity(UsuarioDto usuarioDto);
}