package backend.microserviciovuelos.Service;

import backend.microserviciovuelos.Dao.VueloDao;
import backend.microserviciovuelos.Models.Aeropuerto;
import backend.microserviciovuelos.Models.DTO.AeropuertoDto;
import backend.microserviciovuelos.Models.DTO.AeropuertoMapper;
import backend.microserviciovuelos.Models.DTO.VueloDto;
import backend.microserviciovuelos.Models.DTO.VueloMapper;
import backend.microserviciovuelos.Models.Vuelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VueloServiceImpl implements IVueloService {

    @Autowired
    private VueloDao vueloDao;

    @Autowired
    private  VueloMapper vueloMapper ;

    @Autowired
    private AeropuertoMapper aeropuertoMapper;

    @Autowired
    private AeropuertoServiceImpl aeropuertoService;

    @Override
    @Transactional(readOnly = true)
    public List<VueloDto> findAll() {
        List<Vuelo> vuelos = (List<Vuelo>) vueloDao.findAll();
        List<VueloDto> vuelosDto = vuelos.stream()
                .map(vueloMapper::toVueloDTO)
                .collect(Collectors.toList());
    return  vuelosDto;}

    @Override
    @Transactional(readOnly = true)
    public VueloDto findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("id no puede ser nulo");
        }
        return vueloDao.findById(id)
                .map(vueloMapper::toVueloDTO)
                .orElse(null);
    }

    @Override
    public VueloDto save(VueloDto vueloDto) {
        AeropuertoDto aeropuertoOrigenDto = aeropuertoService.findById(Math.toIntExact(vueloDto.getAeropuertoOrigenId()));
        AeropuertoDto aeropuertoLlegadaDto = aeropuertoService.findById(Math.toIntExact(vueloDto.getAeropuertoLlegadaId()));

        if (aeropuertoOrigenDto == null || aeropuertoLlegadaDto == null) {
            throw new IllegalArgumentException("Aeropuerto origen o llegada no pueden ser nulos");
        }

        // Log de depuración
        System.out.println("Aeropuerto Origen: " + aeropuertoOrigenDto);
        System.out.println("Aeropuerto Llegada: " + aeropuertoLlegadaDto);

        if (aeropuertoOrigenDto.getLatitud() == null || aeropuertoOrigenDto.getLongitud() == null ||
                aeropuertoLlegadaDto.getLatitud() == null || aeropuertoLlegadaDto.getLongitud() == null) {
            throw new IllegalArgumentException("Latitud y longitud no pueden ser nulos");
        }


        Aeropuerto aeropuertoOrigen = aeropuertoMapper.toAeropuerto(aeropuertoOrigenDto);
        Aeropuerto aeropuertoLlegada = aeropuertoMapper.toAeropuerto(aeropuertoLlegadaDto);

        double latOrigen = Double.parseDouble(aeropuertoOrigen.getLatitud());
        double lonOrigen = Double.parseDouble(aeropuertoOrigen.getLongitud());
        double latLlegada = Double.parseDouble(aeropuertoLlegada.getLatitud());
        double lonLlegada = Double.parseDouble(aeropuertoLlegada.getLongitud());

        double distance = FlightCalculator.calculateDistance(latOrigen, lonOrigen, latLlegada, lonLlegada);

        Duration flightDuration = FlightCalculator.calculateFlightDuration(distance);

        ZonedDateTime departureTime = ZonedDateTime.of(vueloDto.getFechaSalida(), LocalTime.parse(vueloDto.getHoraSalida()), ZoneId.systemDefault());
        ZonedDateTime arrivalTime = FlightCalculator.calculateArrivalTime(departureTime, flightDuration);

        long duracionMinutos = flightDuration.toMinutes();

        Vuelo vuelo = Vuelo.builder()
                .numeroVuelo(vueloDto.getNumeroVuelo())
                .aeropuertoOrigen(aeropuertoOrigen)
                .aeropuertoLlegada(aeropuertoLlegada)
                .fechaSalida(vueloDto.getFechaSalida())
                .horaSalida(vueloDto.getHoraSalida().toString())
                .horaLlegada(arrivalTime.toLocalTime().toString())
                .duracion((int) duracionMinutos)
                .precio(vueloDto.getPrecio())
                .estado(vueloDto.getEstado())
                .asientosDisponibles(vueloDto.getAsientosDisponibles())
                .build();

        Vuelo saveVuelo = vueloDao.save(vuelo);
        return vueloMapper.toVueloDTO(saveVuelo);
    }

    @Override
    public void deleteById(Long id) {
        vueloDao.deleteById(id);
    }
}
