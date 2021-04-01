package com.dev.api;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MiPokemonApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiPokemonApiApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder
	            .setConnectTimeout(Duration.ofSeconds(5000))
	            .setReadTimeout(Duration.ofSeconds(5000))
	            .build();
	}
    
	@Bean
	public HttpHeaders getHttpHeaders(RestTemplateBuilder builder) {
		return new HttpHeaders();
	}

}
