package backend.microserviciohoteles.Service;

import backend.microserviciohoteles.Models.DTO.HotelDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IHotelService {

    public List<HotelDto> findAll();

    public HotelDto findById(Long id);

    public HotelDto save(HotelDto hotelDto,  MultipartFile image) throws IOException;

    public void deleteById(Long id);


}
