package backend.microserviciohoteles.Service;

import backend.microserviciohoteles.Dao.HabitacionDao;
import backend.microserviciohoteles.Models.DTO.HabitacionDto;
import backend.microserviciohoteles.Models.DTO.HabitacionMapper;
import backend.microserviciohoteles.Models.Habitacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class HabitacionServiceImpl implements IHabitacionService{

    @Autowired
    private HabitacionDao habitacionDao;

    @Autowired
    private HabitacionMapper habitacionMapper;

    @Autowired
    private CloudinaryService cloudinaryService;


    @Override
    @Transactional(readOnly = true)
    public List<HabitacionDto> findAll() {
        List<Habitacion> habitaciones = (List<Habitacion>) habitacionDao.findAll();
        return habitaciones.stream()
                .map(habitacionMapper::toHabitacionDto)
                .collect(Collectors.toList());

    }

    @Override
    @Transactional(readOnly = true)
    public HabitacionDto findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("id no puede ser nulo");
        }
        return habitacionDao.findById(id)
                .map(habitacionMapper::toHabitacionDto)
                .orElse(null);
    }

    @Override
    public List<HabitacionDto> findByHotelId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("id no puede ser nulo");
        }
        List<Habitacion> habitaciones = habitacionDao.findByHotelId(id);
        return habitaciones.stream()
                .map(habitacionMapper::toHabitacionDto)
                .collect(Collectors.toList());
    }

    @Override
    public HabitacionDto save(HabitacionDto habitacionDto,  MultipartFile image) throws IOException {
        Habitacion habitacion = habitacionMapper.toHabitacion(habitacionDto);
        if(image != null && !image.isEmpty()){
            Map<String, Object> uploadResult = cloudinaryService.upload(image);
            String imageUrl = uploadResult.get("url").toString();
            habitacion.setImagen(imageUrl);
        }
        Habitacion savedHabitacion = habitacionDao.save(habitacion);
        return habitacionMapper.toHabitacionDto(savedHabitacion);
    }



    @Override
    public void deleteById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("id no puede ser nulo");
        }
        Habitacion habitacion= habitacionDao.findById(id).orElse(null);
        if (habitacion != null){
            habitacion.setEstado(false);
            habitacionDao.save(habitacion);
        }
    }
}
