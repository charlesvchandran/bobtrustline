package com.ripple.track.bobtrustline;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.ripple.track")
public class BobtrustlineApplication {
	
	static Logger logger = LoggerFactory.getLogger(BobtrustlineApplication.class);

	public static void main(String[] args) {
		logger.info("Welcome to the Trustline");
		logger.info("Trustline balance is: 0");
		SpringApplication.run(BobtrustlineApplication.class, args);
	}

}

