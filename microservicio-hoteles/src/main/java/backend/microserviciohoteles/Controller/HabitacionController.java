package backend.microserviciohoteles.Controller;

import backend.microserviciohoteles.Models.DTO.HabitacionDto;
import backend.microserviciohoteles.Service.IHabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/habitacion")
@RestController
public class HabitacionController {

    @Autowired
    private IHabitacionService habitacionService;


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
    public HabitacionDto crear(@RequestBody HabitacionDto habitacionDto){
        return habitacionService.save(habitacionDto);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id){
        habitacionService.deleteById(id);
    }


}
