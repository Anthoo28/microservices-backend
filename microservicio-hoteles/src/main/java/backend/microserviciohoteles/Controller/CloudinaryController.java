package backend.microserviciohoteles.Controller;


import backend.microserviciohoteles.Models.DTO.MensajeDto;
import backend.microserviciohoteles.Service.CloudinaryService;
import com.netflix.discovery.converters.Auto;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/cloudinary")
public class CloudinaryController {

    @Autowired
    CloudinaryService cloudinaryService;
    @PostMapping("/upload")
    public ResponseEntity<Map> upload(@RequestParam  MultipartFile multipartFile) throws IOException {
        BufferedImage bi= ImageIO.read(multipartFile.getInputStream());
        if(bi== null){
            return new ResponseEntity(new MensajeDto("imagen no valida"), org.springframework.http.HttpStatus.BAD_REQUEST);
        }
        Map result = cloudinaryService.upload(multipartFile);
        return new ResponseEntity(result, org.springframework.http.HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map> upload(@PathVariable("id") String id ) throws IOException {
        Map result = cloudinaryService.delete(id);
        return new ResponseEntity(result, org.springframework.http.HttpStatus.OK);
    }
}
