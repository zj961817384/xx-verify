package com.xx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.xx"})
public class Application {
    public static void main(String[] args) {

        SpringApplication.run(Application.class);
    }
}
