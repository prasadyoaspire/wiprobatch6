package com.abc.investment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class InvestmentModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvestmentModuleApplication.class, args);
	}
		
	@Bean
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
