package backend.microserviciovuelos.Controller;

import backend.microserviciovuelos.Models.DTO.VueloDto;
import backend.microserviciovuelos.Models.Vuelo;
import backend.microserviciovuelos.Service.IVueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vuelo")
public class VueloController {

    @Autowired
    private IVueloService vueloService;


    @GetMapping("/listar")
    public List<VueloDto> listar(){
    return  vueloService.findAll();
    }

    @GetMapping("/listar/{id}")
    public VueloDto detalle(@PathVariable Long id){
        return vueloService.findById(id);
    }

    @PostMapping("/crear")
    public  VueloDto crear(@RequestBody VueloDto vueloDto){
        return vueloService.save(vueloDto);
    }


}
