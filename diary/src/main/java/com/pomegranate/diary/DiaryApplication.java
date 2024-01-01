package com.pomegranate.diary;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@SpringBootApplication
@Slf4j
@ComponentScan("com.pomegranate")
public class DiaryApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(DiaryApplication.class);
        Environment env = application.run(args).getEnvironment();
        log.info("diary module is running.\tusing port: {}", env.getProperty("server.port"));
    }

}
