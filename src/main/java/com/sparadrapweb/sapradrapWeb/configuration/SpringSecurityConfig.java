package com.sparadrapweb.sapradrapWeb.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    @Autowired
    private CustomService customService;
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    return http.authorizeHttpRequests(auth -> {
            auth.requestMatchers("/Employe").hasRole("ADMIN");
            auth.requestMatchers("/Acceuil,/Patient,/medecin,/Medicament").hasRole("PHARMACIEN");
            auth.anyRequest().authenticated();
        }).formLogin(Customizer.withDefaults()).build(); 
    }
	
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder) throws Exception {
	    AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(customService).passwordEncoder(bCryptPasswordEncoder);
	    return authenticationManagerBuilder.build();
    }
}
