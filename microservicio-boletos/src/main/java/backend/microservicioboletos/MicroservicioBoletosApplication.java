package backend.microservicioboletos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroservicioBoletosApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicioBoletosApplication.class, args);
    }

}
