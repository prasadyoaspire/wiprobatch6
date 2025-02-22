package com.abc.jwtsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {
	
	@Autowired
	private JwtAuthenticationFilter authenticationFilter;
	
	@Autowired
	private JwtAuthenticationEntryPoint authenticationEntryPoint;

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf(csrf -> csrf.disable()).authorizeHttpRequests( authorize -> {		
			authorize
			.requestMatchers("/api/demo/user/**").hasAnyAuthority("USER","ADMIN")
		    .requestMatchers("/api/demo/admin/**").hasAuthority("ADMIN")
		    .requestMatchers("/api/auth/**","/api/demo/guest/*").permitAll();
			
		}).httpBasic(Customizer.withDefaults());
		
		http.exceptionHandling(exception -> exception.authenticationEntryPoint(authenticationEntryPoint));
		
		http.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();		
	}
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}
	
	@Bean
	PasswordEncoder getPasswordEncoder() {		
		return new BCryptPasswordEncoder();
	}
}
