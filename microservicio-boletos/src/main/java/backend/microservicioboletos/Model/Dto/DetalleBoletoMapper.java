package backend.microservicioboletos.Model.Dto;

import backend.microservicioboletos.Model.DetalleBoleto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DetalleBoletoMapper {

    DetalleBoletoDto toDetalleBoletoDto(DetalleBoleto detalleBoleto);

    DetalleBoleto todetalleBoleto(DetalleBoletoDto detalleBoletoDto);


}
