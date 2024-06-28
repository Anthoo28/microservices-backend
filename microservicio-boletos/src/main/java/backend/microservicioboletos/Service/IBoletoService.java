package backend.microservicioboletos.Service;

import backend.microservicioboletos.Model.Dto.BoletoDto;

import java.util.List;

public interface IBoletoService {
    public List<BoletoDto> findAll();
    public BoletoDto findById(Long id);
    public  BoletoDto save(BoletoDto boletoDto);
    public void deleteById(Long id);

}
