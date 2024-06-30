package backend.microserviciopagos.Client;

import backend.microserviciopagos.Model.BoletoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "boleto-service", url = "http://localhost:8090/api/boletos")
public interface BoletoClient {
    @GetMapping("/boleto/listar/{id}")
    BoletoDto getBoleto(@PathVariable("id") Long id);



}
