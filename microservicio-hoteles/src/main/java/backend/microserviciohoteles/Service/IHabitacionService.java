package backend.microserviciohoteles.Service;

import backend.microserviciohoteles.Models.DTO.HabitacionDto;
import backend.microserviciohoteles.Models.DTO.HotelDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IHabitacionService {

    public List<HabitacionDto> findAll();

    public HabitacionDto findById(Long id);

    public HabitacionDto save(HabitacionDto habitacionDto,  MultipartFile image) throws IOException;

    List<HabitacionDto> findByHotelId(Long id);
    public void deleteById(Long id);


}
