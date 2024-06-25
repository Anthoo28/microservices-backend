package backend.microserviciovuelos.Models.DTO;

import backend.microserviciovuelos.Models.Vuelo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = AeropuertoMapper.class)
public interface VueloMapper {

    @Mapping(source = "aeropuertoOrigen.id", target = "aeropuertoOrigenId")
    @Mapping(source = "aeropuertoLlegada.id", target = "aeropuertoLlegadaId")
    VueloDto toVueloDTO(Vuelo vuelo);

    @Mapping(source = "aeropuertoOrigenId", target = "aeropuertoOrigen.id")
    @Mapping(source = "aeropuertoLlegadaId", target = "aeropuertoLlegada.id")
    Vuelo toVuelo(VueloDto vueloDto);
}
