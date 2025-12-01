package com.example.demo.configuracion_web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ConfigurarSeguridadWeb {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/usuarios/**").authenticated()
                .requestMatchers("/api/sugerencias").permitAll()
                .anyRequest().permitAll()
            )
            .formLogin(form -> form
                .loginProcessingUrl("/")
                .successHandler((req, res, auth) -> res.getWriter().write("Login OK"))
                .failureHandler((req, res, ex) -> {
                    res.setStatus(401);
                    res.getWriter().write("Error al iniciar sesión");
                })
                .permitAll()
            )
            .logout(logout -> logout.permitAll());
        return http.build();
    }

    @Bean
    public UserDetailsService users(){
        PasswordEncoder encoder = passwordEncoder();
        UserDetails user = User.builder()
            .username("harold")
            .password(encoder.encode("hola123"))
            .roles("ADMIN")
            .build();

        return  new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
