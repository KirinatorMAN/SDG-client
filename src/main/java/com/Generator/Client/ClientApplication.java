package com.Generator.Client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
public class ClientApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(ClientApplication.class, args);
		Multithreading multithreading = new Multithreading(ctx,Integer.parseInt(args[0]));
		multithreading.run();
	}
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}

