package backend.apigateway.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
@Configuration
public class SpringSecurityConfig {

    @Autowired
    private JwtAuthenticationFilter authenticationFilter;

    @Bean
    public SecurityWebFilterChain configure(ServerHttpSecurity http) {
        return http.authorizeExchange()
                .pathMatchers("/api/security/**","/api/usuarios/usuarios").permitAll()
                .pathMatchers(HttpMethod.GET,
                        "/api/vuelos/vuelo/listar/{id}",
                        "/api/vuelos/vuelo/listar",
                        "/api/hoteles/listar",
                        "/api/hoteles/listar/{id}",
                        "/api/usuarios/usuarios"
                ).permitAll()
                .pathMatchers(HttpMethod.GET, "/api/usuarios/usuarios/{id}","/api/boletos/boleto/listar").permitAll()
                .pathMatchers("/api/vuelos/**", "/api/hoteles/**", "/api/usuarios/usuarios/**", "/api/boletos/**", "/api/pagos/**").permitAll()
                .anyExchange().authenticated()
                .and().addFilterAt(authenticationFilter, SecurityWebFiltersOrder.AUTHENTICATION)
                .csrf().disable()
                .build();
    }
}
