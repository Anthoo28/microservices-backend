package backend.microservicioboletos.Controller;

import backend.microservicioboletos.Model.Dto.BoletoDto;
import backend.microservicioboletos.Service.IBoletoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/boleto")
@RestController

public class BoletoController {

    @Autowired
    private IBoletoService boletoService;

    @GetMapping("/listar")
    public List<BoletoDto> listar(){
        return boletoService.findAll();
    }
    @GetMapping("/listar/{id}")
    public BoletoDto detalle(Long id){
        return boletoService.findById(id);
    }
    @PostMapping("/crear")
    public BoletoDto crear(@RequestBody  BoletoDto boletoDto){
        return boletoService.save(boletoDto);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(Long id){
        boletoService.deleteById(id);
    }

}
