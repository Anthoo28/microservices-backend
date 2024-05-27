package backend.microserviciohoteles.Models.DTO;

import backend.microserviciohoteles.Models.Hotel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface HotelMapper {

    public HotelDto toHotelDto(Hotel hotel);

    public Hotel toHotel(HotelDto hotelDto);
}
