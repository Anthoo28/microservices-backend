package backend.microserviciohoteles.Models.DTO;

import backend.microserviciohoteles.Models.Hotel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HotelMapper {

    public HotelDto toHotelDto(Hotel hotel);

    public Hotel toHotel(HotelDto hotelDto);
}
