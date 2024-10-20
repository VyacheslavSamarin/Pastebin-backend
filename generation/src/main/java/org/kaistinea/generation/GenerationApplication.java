package org.kaistinea.generation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GenerationApplication {
    public static void main(String[] args) {
        SpringApplication.run(GenerationApplication.class, args);
    }
}
