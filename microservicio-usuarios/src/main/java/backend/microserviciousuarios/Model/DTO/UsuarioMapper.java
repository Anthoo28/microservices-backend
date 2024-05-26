package backend.microserviciousuarios.Model.DTO;

import backend.microserviciousuarios.Model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "estado", target = "estado")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "direccion", target = "direccion")
    @Mapping(source = "telefono", target = "telefono")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "contraseña", target = "contraseña")
    @Mapping(source = "imagen", target = "imagen")
    UsuarioDto toDTO(Usuario usuario);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "estado", target = "estado")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "direccion", target = "direccion")
    @Mapping(source = "telefono", target = "telefono")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "contraseña", target = "contraseña")
    @Mapping(source = "imagen", target = "imagen")
    Usuario toEntity(UsuarioDto usuarioDto);
}