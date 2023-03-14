package com.mx.oneIt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class OneItApplication {

	@Bean
	AuditorAware<Long> auditorProvider(){
		return new AuditorAwareImpl();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(OneItApplication.class, args);
	}

}
