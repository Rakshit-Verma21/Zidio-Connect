package com.example.zidio_connection.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig
{
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity)
        throws Exception{

        httpSecurity.csrf().disable().authorizeHttpRequests(
                authorizationManagerRequestMatcherRegistry
                        -> authorizationManagerRequestMatcherRegistry
                        .requestMatchers("/api/auth/**","/api/students/**","/api/recruiter/**","/api/jobPosts/**","/api/applications/**","/api/admin/**","/api/payments/**","/api/subscription_status/**","/api/billing/**","/api/razorpay/**","/api/subscription-plans/**","/api/stripe/**","/api/checkout/**","/api/webhook/**","/api/subscription/**","/api/subscription-plans/**")
                .permitAll().anyRequest().authenticated());
        return httpSecurity.build();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }


}
