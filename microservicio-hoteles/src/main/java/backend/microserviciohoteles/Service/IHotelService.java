package backend.microserviciohoteles.Service;

import backend.microserviciohoteles.Models.DTO.HotelDto;

import java.util.List;

public interface IHotelService {

    public List<HotelDto> findAll();

    public HotelDto findById(Long id);

    public HotelDto save(HotelDto hotelDto);



    public void deleteById(Long id);


}
