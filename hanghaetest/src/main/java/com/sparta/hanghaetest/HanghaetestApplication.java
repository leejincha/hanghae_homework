package com.sparta.hanghaetest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HanghaetestApplication {

    public static void main(String[] args) {
        SpringApplication.run(HanghaetestApplication.class, args);
    }

}
