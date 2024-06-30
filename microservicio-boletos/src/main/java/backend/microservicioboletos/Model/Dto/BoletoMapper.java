package backend.microservicioboletos.Model.Dto;

import backend.microservicioboletos.Model.Boleto;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface BoletoMapper {
    BoletoDto toBoletoDto(Boleto boleto);
    Boleto toboleto(BoletoDto boletoDto);
    List<Boleto> toBoletos(List<BoletoDto> boletoDtos);
    List<BoletoDto> toBoletoDtos(List<Boleto> boletos);
}
