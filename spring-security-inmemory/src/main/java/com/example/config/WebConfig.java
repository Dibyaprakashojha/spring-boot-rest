package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebConfig extends WebSecurityConfigurerAdapter {

    //do authenticate

    /**
     *
     * @param auth
     * @throws Exception
     * @author Dibya Prakash Ojha
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // to perform in-memory authentication
        // hard code the username and password
        auth.inMemoryAuthentication()
                .withUser("Kathy")
                .password(passwordEncoder().encode("asd123"))
                .roles("USER")
                .and()
                .withUser("Admin")
                .password(passwordEncoder().encode("admin123"))
                .roles("ADMIN","USER");
    }

    // to encode the password, use BCryptPasswordEncoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //do authorisation


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/products/**").hasAnyRole("ADMIN","USER")
                .and()
                .formLogin();
    }
}
