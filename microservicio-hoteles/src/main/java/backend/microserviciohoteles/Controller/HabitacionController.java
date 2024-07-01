package backend.microserviciohoteles.Controller;

import backend.microserviciohoteles.Models.DTO.HabitacionDto;
import backend.microserviciohoteles.Service.IHabitacionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequestMapping("/habitacion")
@RestController


public class HabitacionController {

    @Autowired
    private IHabitacionService habitacionService;

    @Autowired
    private ObjectMapper objectMapper;


    @GetMapping("/listar")
    public List<HabitacionDto> listar(){
        return habitacionService.findAll();
    }

    @GetMapping("/listar/{id}")
    public HabitacionDto detalle(@PathVariable Long id){
        return habitacionService.findById(id);
    }
    @GetMapping("/listarHotel/{hotelId}")
    public List<HabitacionDto> listarPorHotel(@PathVariable Long hotelId){
        return habitacionService.findByHotelId(hotelId);
    }

    @PostMapping("/crear")
    public HabitacionDto crear(@RequestPart("habitacion") String habitacionJson,
                               @RequestPart("imagen") MultipartFile imagen) throws IOException {
        HabitacionDto habitacionDto = objectMapper.readValue(habitacionJson, HabitacionDto.class);
        return habitacionService.save(habitacionDto,imagen);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id){
        habitacionService.deleteById(id);
    }


}
