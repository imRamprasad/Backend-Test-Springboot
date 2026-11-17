package com.Monolitic.monolitic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
		"com.Monolitic.monolitic",
		"project.firstApplication"
})

@EntityScan(basePackages = {
		"com.Monolitic.monolitic.entity",
		"project.firstApplication.empmanagesystem.entity"
})
@EnableJpaRepositories(basePackages = {
		"com.Monolitic.monolitic.repository",
		"project.firstApplication.empmanagesystem.repository"
})
public class MonoliticApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonoliticApplication.class, args);
	}

}
