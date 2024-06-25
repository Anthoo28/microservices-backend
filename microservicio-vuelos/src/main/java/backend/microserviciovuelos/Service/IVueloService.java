package backend.microserviciovuelos.Service;

import backend.microserviciovuelos.Models.DTO.VueloDto;

import java.util.List;

public interface IVueloService {

    public List<VueloDto> findAll();

    public VueloDto findById(Long id);
    public VueloDto save(VueloDto vueloDto);
    public void deleteById(Long id);

}
