package backend.microserviciousuarios.Controller;

import backend.microserviciousuarios.Model.DTO.UsuarioDto;
import backend.microserviciousuarios.Model.Usuario;
import backend.microserviciousuarios.Service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/listar")
    public List<UsuarioDto> listar(){
        return usuarioService.findAll();
    }

    @GetMapping("/listar/{id}")
    public UsuarioDto detalle(@PathVariable Long id){
        return usuarioService.findById(id);
    }

    @PostMapping("/crear")
    public  UsuarioDto crear(@RequestBody UsuarioDto usuarioDto){
        return usuarioService.save(usuarioDto);
    }


    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id){
        usuarioService.deleteById(id);
    }

}
