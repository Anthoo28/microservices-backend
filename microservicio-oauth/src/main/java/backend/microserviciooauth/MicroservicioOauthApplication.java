package backend.microserviciooauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class MicroservicioOauthApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicioOauthApplication.class, args);
    }

}
