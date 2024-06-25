package backend.microserviciovuelos.Service;

import java.time.Duration;
import java.time.ZonedDateTime;

public class FlightCalculator {

    private static final double EARTH_RADIUS = 6371.0; // Radio de la tierra en km
    private static final double FLIGHT_SPEED_KM_PER_HOUR = 700.0; // Velocidad promedio de un avión en km/h

    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // Convertir coordenadas de grados a radianes
        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);

        // Calcular las diferencias de latitud y longitud en radianes
        double deltaLat = lat2Rad - lat1Rad;
        double deltaLon = lon2Rad - lon1Rad;

        // Aplicar la fórmula de Haversine para calcular la distancia entre dos puntos
        double a = Math.pow(Math.sin(deltaLat / 2), 2)
                + Math.cos(lat1Rad) * Math.cos(lat2Rad)
                * Math.pow(Math.sin(deltaLon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = EARTH_RADIUS * c;

        return distance;
    }

    public static Duration calculateFlightDuration(double distance) {
        // Calcular la duración del vuelo en minutos
        double hours = distance / FLIGHT_SPEED_KM_PER_HOUR;
        long minutes = (long) (hours * 60); // Convertir horas a minutos

        // Crear y retornar la duración en minutos
        return Duration.ofMinutes(minutes);
    }

    public static ZonedDateTime calculateArrivalTime(ZonedDateTime departureTime, Duration flightDuration) {
        // Calcular y retornar la hora estimada de llegada sumando la duración del vuelo a la hora de salida
        return departureTime.plus(flightDuration);
    }
}
