package com.capg.god;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capg.god.controller.WishlistController;

@SpringBootApplication
public class GreaterOutdoorApplication {
	
	public static void main(String[] args) {
		Logger log =LoggerFactory.getLogger(WishlistController.class);
		SpringApplication.run(GreaterOutdoorApplication.class, args);
		log.info("springboot started");
	}

}
