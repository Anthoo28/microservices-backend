package backend.microservicioboletos.client;

import backend.microservicioboletos.Model.Dto.VueloDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "vuelo-service", url = "http://localhost:8090/api/vuelos")
public interface VueloClient {
    @GetMapping("/vuelo/listar/{id}")
    VueloDto getVuelo(@PathVariable("id") Long id);
}