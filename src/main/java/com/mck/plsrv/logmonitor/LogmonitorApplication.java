package com.mck.plsrv.logmonitor;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LogmonitorApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(LogmonitorApplication.class, args);
		System.out.println("Spring Boot app started.");

	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}
	
/*
    try (CloseableHttpClient client = HttpClients.createDefault()) {

        HttpGet request = new HttpGet("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY");

        APOD response = client.execute(request, httpResponse ->
            mapper.readValue(httpResponse.getEntity().getContent(), APOD.class));

        System.out.println(response.title);
    }
*/
	
}
