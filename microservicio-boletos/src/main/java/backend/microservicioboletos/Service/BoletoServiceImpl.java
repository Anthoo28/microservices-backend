package backend.microservicioboletos.Service;

import backend.microservicioboletos.Dao.BoletoDao;
import backend.microservicioboletos.Model.Boleto;
import backend.microservicioboletos.Model.CategoriaViaje;
import backend.microservicioboletos.Model.DetalleBoleto;
import backend.microservicioboletos.Model.Dto.BoletoDto;
import backend.microservicioboletos.Model.Dto.BoletoMapper;
import backend.microservicioboletos.Model.Dto.DetalleBoletoDto;
import backend.microservicioboletos.Model.Dto.VueloDto;
import backend.microservicioboletos.client.VueloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoletoServiceImpl implements IBoletoService{


    @Autowired
    private BoletoDao boletoDao;

    @Autowired
    private BoletoMapper boletoMapper;
    @Autowired
    private VueloClient vueloClient;
    @Autowired
    private VueloDto vueloDto;
    @Autowired
    private DetalleBoletoDto detalleBoletoDto;
    @Autowired
    private BoletoDto boletoDto;

    @Override
    @Transactional(readOnly = true)
    public List<BoletoDto> findAll() {
        List<Boleto>boletos=(List<Boleto>) boletoDao.findAll();
                return boletos.stream()
                        .map(boletoMapper::toBoletoDto)
                        .collect(Collectors.toList());
    }



    @Override
    public BoletoDto findById(Long id) {
        if(id==null){
            throw new IllegalArgumentException("El id no puede ser nulo");
        }
        return boletoDao.findById(id)
                .map(boletoMapper::toBoletoDto)
                .orElse(null);
    }

    @Override
    public BoletoDto save(BoletoDto boletoDto) {
        // Validaciones iniciales
        if (boletoDto == null) {
            throw new IllegalArgumentException("El boleto no puede ser nulo");
        }

        Long idVuelo = boletoDto.getIdVuelo();
        if (idVuelo == null) {
            throw new IllegalArgumentException("El id de vuelo no puede ser nulo");
        }

        // Obtener datos del vuelo
        VueloDto vuelo = vueloClient.getVuelo(idVuelo);
        if (vuelo == null) {
            throw new IllegalArgumentException("El vuelo con id " + idVuelo + " no existe");
        }

        // Convertir BoletoDto a entidad Boleto
        Boleto boleto = boletoMapper.toboleto(boletoDto);

        // Calcular precio inicial y precio final
        Double precioFinal = 0.0;
        List<DetalleBoleto> detalles = new ArrayList<>();
        for (DetalleBoletoDto detalleDto : boletoDto.getDetallesBoleto()) {
            Double valorCategoria = 0.0;
            if (detalleDto.getCategoriaViaje() != null) {
                valorCategoria = detalleDto.getCategoriaViaje().getAdicional();
            }
            Double precioInicial = vuelo.getPrecio() + valorCategoria;

            DetalleBoleto detalle = new DetalleBoleto();
            detalle.setNombreCompleto(detalleDto.getNombreCompleto());
            detalle.setDni(detalleDto.getDni());
            detalle.setAsiento(detalleDto.getAsiento());
            detalle.setCategoriaViaje(detalleDto.getCategoriaViaje());
            detalle.setEsIda(detalleDto.isEsIda());
            detalle.setPrecioUnitario(precioInicial);
            boleto.setFechaEmision(Date.valueOf(LocalDate.now()));
            boleto.setEstado("ACTIVO");

            detalles.add(detalle);
            precioFinal += precioInicial;
        }
        boleto.setDetallesBoleto(detalles);
        boleto.setPrecioFinal(precioFinal);

        // Guardar el boleto y sus detalles
        Boleto savedBoleto = boletoDao.save(boleto);

        // Convertir la entidad guardada a BoletoDto y devolverla
        return boletoMapper.toBoletoDto(savedBoleto);
    }


    @Override
    public void deleteById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }
        Boleto boleto=boletoDao.findById(id).orElse(null);
        if(boleto!=null){
            boleto.setEstado("CANCELADO");
            boletoDao.deleteById(id);
        }
    }
}
