package com.store.gamestop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication
@SpringBootApplication
//@ComponentScan(basePackages = {"com.store.GameStopApplication"})

public class GameStopApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameStopApplication.class, args);
	}

}
