package com.example.demobackend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 * WebSecurityConfiguration is a Configuration that handles the Web Security topic, sets up a PasswordEncoder,
 * and configures the anonymous and authenticated requests, as well as the login and logout function
 */
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    /**
     * The method is used for creating a delegating PasswordEncoder
     *
     * @return the return value is a PasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    /**
     * The method is used for configuring and authorizing requests, defining the anonymous and authenticated
     * requests, login, logout and the authentification entry points
     *
     * @param http is a HttpSecurity object
     * @throws Exception is a checked Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/api/", "/api/sessionUser","/api/entryDetail/*", "/api/entries","/api/entry/*","/api/entries/*","/api/entry","/api/register","/api/yorum/*","/api/yorum", "/api/registration", "/api/register/*",  "/api/login", "/login").permitAll()
                .anyRequest().authenticated().and()
                .formLogin()
                .and()
                .httpBasic().and()
                .exceptionHandling()
                .authenticationEntryPoint(new Http403ForbiddenEntryPoint()).and()
                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());

        http.logout().logoutUrl("/api/logout")
                .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler());
    }
}
