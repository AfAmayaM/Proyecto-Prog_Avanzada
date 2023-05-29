package co.edu.uniquindio.proyecto.proyectotienda.seguridad;

import co.edu.uniquindio.proyecto.proyectotienda.seguridad.config.JwtAuthenticationEntryPoint;
import co.edu.uniquindio.proyecto.proyectotienda.seguridad.config.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final JwtAuthenticationEntryPoint jwtEntryPoint;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.cors();
        http.authorizeHttpRequests().requestMatchers("/api/auth/**",
                        "/api/usuarios/crear",
                        "/api/cuenta/cambiarContra",
                        "/api/cuenta/recuperarContra",
                        "/api/categorias/listar",
                        "/api/publicacion/listarNombre",
                        "/api/publicacion/listarCategoria",
                        "/api/publicacion/listarPrecio",
                        "/api/publicacion/listarOfertas",
                        "/api/publicacion/obtener/**",
                        "/api/usuarios/obtener/**").permitAll()
                .requestMatchers("/api/comentario/crear", "/api/comentario/listar").hasAuthority("CLIENTE")
                .requestMatchers("/api/moderador/**", "/api/publicacion/listarEstado").hasAuthority("MODERADOR").anyRequest().authenticated();
        http.exceptionHandling().authenticationEntryPoint(jwtEntryPoint);
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authenticationProvider(authenticationProvider);
        http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}