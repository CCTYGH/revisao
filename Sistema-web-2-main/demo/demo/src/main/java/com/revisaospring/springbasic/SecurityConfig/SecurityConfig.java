package com.revisaospring.springbasic.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.revisaospring.springbasic.Service.CustomUserDetailsService;


@Configuration
public class SecurityConfig {

    private final CustomUserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(CustomUserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        //onde as requisições irão passar
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    //Todas as requisições são bloqueada, elas serão liberadas no RequesMatchers
                    "/usuarioCTR/formCadastrarUsuario",
                    "/usuarioCTR/login",
                    "/usuarioCTR/salvarUsuario",
                    "/usuarioCTR/listarUsuarios",
                    "/produtoCTR/**").permitAll()// ** libera todas as requisições, não é recomendada
                .anyRequest().authenticated()// ela permitir todas requisições  com permissão
            )
            .formLogin(form -> form // fala pro spring security qual é a pagina de login e o caminho para a pagina
                .loginPage("/usuarioCTR/login")
                .loginProcessingUrl("/login") //URl que trata o login, na pagina LOGIN.HTML
                .defaultSuccessUrl("/usuarioCTR/listarUsuarios", true)// cadastrar qual que é a pagina inicial que o usario vai quando colocar o login
                .permitAll()
            )
            .userDetailsService(userDetailsService) //Referencia da classe
            .csrf(csrf -> csrf.disable()); //Segurança contra ameças que tentam clonar a pagina para roubar dados, e direciona o usuer para a pagina certa
            
        return http.build();// retorna para o usuario
    }

}