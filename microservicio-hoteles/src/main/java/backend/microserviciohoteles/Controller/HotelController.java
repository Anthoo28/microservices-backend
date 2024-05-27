package backend.microserviciohoteles.Controller;


import backend.microserviciohoteles.Models.DTO.HotelDto;
import backend.microserviciohoteles.Service.IHotelService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HotelController {

    @Autowired
    private IHotelService hotelService;

    @GetMapping("/listar")
    public List<HotelDto> listar(){
        return hotelService.findAll();
    }


}
