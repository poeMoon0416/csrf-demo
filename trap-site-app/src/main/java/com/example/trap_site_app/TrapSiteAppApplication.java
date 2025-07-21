package com.example.trap_site_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class TrapSiteAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrapSiteAppApplication.class, args);
	}

}
