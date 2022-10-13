package edu.eci.arsw.digital_waitersapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.eci.arsw.digital_waiter"})
public class DigitalWaiterAPIApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalWaiterAPIApplication.class, args);
	}

}
