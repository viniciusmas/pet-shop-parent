package br.edu.infnet.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"br.edu.infnet.main", "br.edu.infnet.api"})
@EnableFeignClients(basePackages = "br.edu.infnet.api.clients")
@EntityScan(basePackages = "br.edu.infnet.common.model.domain")
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
}
