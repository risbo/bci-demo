package com.bci.demo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "BCI API", version = "1.0", description = "BCI Information"))
public class BciDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BciDemoApplication.class, args);
	}

}
