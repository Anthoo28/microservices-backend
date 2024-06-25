package backend.microserviciovuelos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Duration;
import java.time.ZonedDateTime;

import static backend.microserviciovuelos.Service.FlightCalculator.*;

@SpringBootApplication
public class MicroservicioVuelosApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicioVuelosApplication.class, args);

        // Ejemplo de uso
        double lat1 = -12.0219;
        double lon1 = -77.1143;
        double lat2 = -16.342;
        double lon2 = -71.5682;

        // Calcular distancia entre los aeropuertos
        double distance = calculateDistance(lat1, lon1, lat2, lon2);
        System.out.println("Distancia entre los aeropuertos: " + distance + " km");

        // Calcular duración del vuelo estimada
        Duration flightDuration = calculateFlightDuration(distance);
        System.out.println("Duración del vuelo estimada: " + flightDuration.toMinutes() + " minutos");

        // Hora de salida (usando la hora actual como ejemplo)
        ZonedDateTime departureTime = ZonedDateTime.now();
        System.out.println("Hora de salida: " + departureTime);

        // Calcular hora estimada de llegada
        ZonedDateTime arrivalTime = calculateArrivalTime(departureTime, flightDuration);
        System.out.println("Hora estimada de llegada: " + arrivalTime);
    }

}
