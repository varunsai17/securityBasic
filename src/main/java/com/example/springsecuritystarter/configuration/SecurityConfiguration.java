package com.example.springsecuritystarter.configuration;

import com.example.springsecuritystarter.service.MyCustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests(requests -> {
            requests.requestMatchers("/hi", "/bye").permitAll();
            requests.requestMatchers("user/**").hasRole("user");
            requests.requestMatchers("admin/**").hasRole("admin");
            requests.anyRequest().authenticated();
        }).formLogin(AbstractAuthenticationFilterConfigurer::permitAll).
        build();
    }


    //use below userdetails service if you don't have any sql database

//    @Bean
//    public UserDetailsService basicInMemory() {
//        UserDetails userDetails = User.builder().
//                username("varun").
//                password("v").
//                roles("user", "admin").
//                build();
//
//
//        return new InMemoryUserDetailsManager(userDetails);
//    }


    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        return daoAuthenticationProvider;
    }
}
