package com.almadetortuga.back_AlmaDeTortuga.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    //Config para permitir cualquier peticion (No auth)
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        // Desahabilitar la seguridad de todas las peticiones externas
        http.csrf(crsf -> crsf.disable())
                //Configurar para que cualquier usuario pueda realizar peticiones
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
                //La configuracion basica puede requerir un user y un password
                .httpBasic(Customizer.withDefaults());
        //Construir el nuevo http
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }
}
