package backend.microserviciopagos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroservicioPagosApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicioPagosApplication.class, args);
    }

}
