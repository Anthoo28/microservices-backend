package backend.microserviciohoteles.Service;

import backend.microserviciohoteles.Dao.HotelDao;
import backend.microserviciohoteles.Models.DTO.HotelDto;
import backend.microserviciohoteles.Models.DTO.HotelMapper;
import backend.microserviciohoteles.Models.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements IHotelService{

    @Autowired
    private HotelDao hotelDao;

    @Autowired
    private HotelMapper hotelMapper;


    @Override
    @Transactional(readOnly = true)
    public List<HotelDto> findAll() {
        List<Hotel> hoteles = (List<Hotel>) hotelDao.findAll();
        return hoteles.stream()
                .map(hotelMapper::toHotelDto)
                .collect(Collectors.toList());

    }

    @Override
    @Transactional(readOnly = true)
    public HotelDto findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("id no puede ser nulo");
        }
        return hotelDao.findById(id)
                .map(hotelMapper::toHotelDto)
                .orElse(null);
    }

    @Override
    public HotelDto save(HotelDto hotelDto) {
    Hotel hotel = hotelMapper.toHotel(hotelDto);
        Hotel savedHotel = hotelDao.save(hotel);
        return hotelMapper.toHotelDto(savedHotel);
    }

    @Override
    public void deleteById(Long id) {
        if(id == null){
            throw new IllegalArgumentException("id no puede ser nulo");
        }
        Hotel hotel = hotelDao.findById(id).orElse(null);
        if(hotel != null){
    hotel.setEstado(false);
hotelDao.save(hotel);
            }
    }
}
