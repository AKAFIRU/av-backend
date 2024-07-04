package com.aula.sproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.wavefront.WavefrontProperties.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.aula.sproject.repository")
@EntityScan(basePackages = "com.aula.sproject.entity")
public class SprojectApplication  extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(SprojectApplication.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

}
