package backend.microserviciohoteles.Service;

import backend.microserviciohoteles.Models.DTO.HabitacionDto;
import backend.microserviciohoteles.Models.DTO.HotelDto;

import java.util.List;

public interface IHabitacionService {

    public List<HabitacionDto> findAll();

    public HabitacionDto findById(Long id);

    public HabitacionDto save(HabitacionDto habitacionDto);

    List<HabitacionDto> findByHotelId(Long id);
    public void deleteById(Long id);


}
