package org.kaistinea.generation;

import org.kaistinea.common.annotation.KaistineaResourceServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@KaistineaResourceServer
public class GenerationApplication {
    public static void main(String[] args) {
        SpringApplication.run(GenerationApplication.class, args);
    }
}
