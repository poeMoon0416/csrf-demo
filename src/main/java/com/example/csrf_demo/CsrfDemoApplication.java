package com.example.csrf_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CsrfDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsrfDemoApplication.class, args);
	}

	// CORSの許可設定, 別のページからログインページを経由して間接的にアクセスした場合も最初のリクエストを弾くような挙動をしていた
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/login").allowedOrigins("http://localhost:4444").allowedMethods("POST", "GET");
				registry.addMapping("/").allowedOrigins("http://localhost:4444").allowedMethods("GET", "POST");
			}
		};
	}
}
