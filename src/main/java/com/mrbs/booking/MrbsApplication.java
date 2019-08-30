package com.mrbs.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.mrbs.booking.controller","com.mrbs.booking"})
@EntityScan(basePackages = {"com.mrbs.booking.bean"})
@EnableJpaRepositories(basePackages = {"com.mrbs.booking.repository"})
@SpringBootApplication
public class MrbsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MrbsApplication.class, args);
		
	}

}
