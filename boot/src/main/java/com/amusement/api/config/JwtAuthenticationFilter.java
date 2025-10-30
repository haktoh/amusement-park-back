package com.amusement.api.config;

import com.amusement.api.application.service.JwtService;
import com.amusement.api.driven.persistence.jpa.security.UserDetailsAdapterService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component // Le dice a Spring que cree un Bean de este filtro
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter { // Se ejecuta 1 vez por petición

    private final JwtService jwtService; // El "Cerrajero"
    private final UserDetailsAdapterService userDetailsService; // El "Verificador"

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain) throws ServletException, IOException {

        // 1. Coge la cabecera "Authorization" de la petición
        final String authHeader = request.getHeader("Authorization");

        // 2. Si no hay cabecera, o no empieza por "Bearer ", es una petición anónima
        //    (ej. /login o /register). La dejamos pasar al siguiente filtro.
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        // 3. Si tiene "Bearer ", extraemos el token (quitando "Bearer ")
        final String jwt = authHeader.substring(7);

        // 4. Usamos el "Cerrajero" para sacar el email del token
        final String userEmail = jwtService.getUsernameFromToken(jwt);

        // 5. Si tenemos email Y el usuario no está YA autenticado en esta sesión...
        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            // 6. Usamos el "Verificador" para cargar el usuario de la BBDD
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);

            // 7. Si el token es válido (comprueba firma y expiración)...
            if (jwtService.isTokenValid(jwt, userDetails)) {

                // 8. Creamos una "sesión" de autenticación para Spring
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null, // No necesitamos credenciales (password)
                        userDetails.getAuthorities()
                );
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // 9. ¡AUTENTICADO! Guardamos la sesión en el Contexto de Seguridad
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        // 10. Pasamos al siguiente filtro de la cadena
        filterChain.doFilter(request, response);
    }
}