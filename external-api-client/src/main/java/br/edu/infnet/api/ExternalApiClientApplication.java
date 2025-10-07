package br.edu.infnet.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ExternalApiClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExternalApiClientApplication.class, args);
	}

}
