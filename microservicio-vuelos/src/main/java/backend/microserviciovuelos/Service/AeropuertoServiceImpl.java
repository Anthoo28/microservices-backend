package backend.microserviciovuelos.Service;

import backend.microserviciovuelos.Dao.AeropuertoDao;
import backend.microserviciovuelos.Models.Aeropuerto;
import backend.microserviciovuelos.Models.DTO.AeropuertoDto;
import backend.microserviciovuelos.Models.DTO.AeropuertoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AeropuertoServiceImpl implements IAeropuertoService{
    @Autowired
    private AeropuertoDao aeropuertoDao;
    @Autowired
    private AeropuertoMapper aeropuertoMapper;


    @Override
    @Transactional(readOnly = true)
    public List<AeropuertoDto> findAll() {
        List<Aeropuerto>aeropuertos= (List< Aeropuerto>)aeropuertoDao.findAll();
        return aeropuertos.stream()
                .map(aeropuertoMapper::toAeropuertoDTO)
                .collect(Collectors.toList());
    }
    @Override
    @Transactional(readOnly = true)
    public AeropuertoDto findById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("id no puede ser nulo");
        }

        Aeropuerto aeropuerto = aeropuertoDao.findById(id).orElse(null);

        // Log de depuración
        System.out.println("Aeropuerto encontrado: " + aeropuerto);

        if (aeropuerto == null) {
            return null;
        }

        AeropuertoDto aeropuertoDto = aeropuertoMapper.toAeropuertoDTO(aeropuerto);

        // Log de depuración
        System.out.println("Aeropuerto DTO: " + aeropuertoDto);

        return aeropuertoDto;
    }
}
