package backend.microserviciohoteles.Controller;


import backend.microserviciohoteles.Models.DTO.HotelDto;
import backend.microserviciohoteles.Service.IHotelService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class HotelController {

    @Autowired
    private IHotelService hotelService;

    @GetMapping("/listar")
    public List<HotelDto> listar(){
        return hotelService.findAll();
    }

    @GetMapping("/listar/{id}")
    public HotelDto detalle(@PathVariable Long id){
        return hotelService.findById(id);
    }

    @PostMapping("/crear")
    public HotelDto crear(@RequestBody HotelDto hotelDto){
        return hotelService.save(hotelDto);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id){
        hotelService.deleteById(id);
    }



}
