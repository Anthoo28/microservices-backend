package backend.microserviciovuelos.Models.DTO;

import backend.microserviciovuelos.Models.Vuelo;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring", uses = {AeropuertoMapper.class})
public interface VueloMapper {

    VueloDto toVueloDTO(Vuelo vuelo);

    Vuelo toVuelo(VueloDto vueloDto);
}
