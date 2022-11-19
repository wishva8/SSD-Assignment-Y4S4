//SSD Assignment 2
package com.ihub.janus.app;

import com.ihub.janus.app.service.AttachmentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * The Class JanusApplication.
 */
@SpringBootApplication
@EntityScan(basePackages = { "com.ihub.janus.data.entity" })
@EnableJpaRepositories(basePackages = { "com.ihub.janus.data.repository" })
public class JanusApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(JanusApplication.class, args);
		AppBanner.printBanner();
	}

	@Bean
	CommandLineRunner init(AttachmentService attachmentService) {
		return (args) -> {
			attachmentService.deleteAll();
			attachmentService.init();
		};
	}

}