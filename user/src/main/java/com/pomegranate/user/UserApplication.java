package com.pomegranate.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@SpringBootApplication
@ComponentScan("com.pomegranate")
@Slf4j
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(UserApplication.class);
		Environment env = application.run(args).getEnvironment();
		log.info("user module is running.\tusing port: {}", env.getProperty("server.port"));
	}

}
