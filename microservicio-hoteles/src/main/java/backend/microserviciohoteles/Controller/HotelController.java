package backend.microserviciohoteles.Controller;


import backend.microserviciohoteles.Models.DTO.HotelDto;
import backend.microserviciohoteles.Service.IHotelService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin("*")
@RestController
public class HotelController {

    @Autowired
    private IHotelService hotelService;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/listar")
    public List<HotelDto> listar(){
        return hotelService.findAll();
    }

    @GetMapping("/listar/{id}")
    public HotelDto detalle(@PathVariable Long id){
        return hotelService.findById(id);
    }

    @PostMapping("/crear")
    public HotelDto crear(@RequestPart("hotel") String hotelJson,
                          @RequestPart("imagen") MultipartFile imagen) throws IOException {
        HotelDto hotelDto = objectMapper.readValue(hotelJson, HotelDto.class);
        return hotelService.save(hotelDto, imagen);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id){
        hotelService.deleteById(id);
    }



}
