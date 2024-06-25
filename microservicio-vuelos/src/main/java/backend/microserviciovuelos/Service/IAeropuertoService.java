package backend.microserviciovuelos.Service;

import backend.microserviciovuelos.Models.DTO.AeropuertoDto;

import java.util.List;

public interface IAeropuertoService {

    public  List<AeropuertoDto> findAll();
    public AeropuertoDto findById(Integer id);

}
