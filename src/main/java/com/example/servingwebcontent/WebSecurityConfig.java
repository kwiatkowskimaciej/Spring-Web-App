package com.example.servingwebcontent;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/index", "/resources/**", "/resources/static/**", "/greeting").permitAll()
                        .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
                        .requestMatchers("/webjars/**").permitAll()
                        .requestMatchers("/main").authenticated()
                        .requestMatchers("/main_admin", "/salon", "/new_salon", "/edit_salon", "/save_salon").hasRole("ADMIN")
                        .requestMatchers("/main_employee").hasRole("EMPLOYEE")
                        .requestMatchers("/main_client").hasRole("CLIENT")
                        .anyRequest().permitAll()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/main")
                        .permitAll()
                )
                .logout((logout) -> logout
                        .logoutUrl("/index")
                        .logoutSuccessUrl("/index")
                        .permitAll());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails klient =
                User.withDefaultPasswordEncoder()
                        .username("client")
                        .password("client")
                        .roles("CLIENT")
                        .build();
        UserDetails pracownik =
                User.withDefaultPasswordEncoder()
                        .username("employee")
                        .password("employee")
                        .roles("EMPLOYEE")
                        .build();
        UserDetails admin =
                User.withDefaultPasswordEncoder()
                        .username("admin")
                        .password("admin")
                        .roles("ADMIN")
                        .build();

        return new InMemoryUserDetailsManager(klient, pracownik, admin);
    }
}
