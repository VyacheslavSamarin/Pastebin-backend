package org.kaistinea.paste;

import org.kaistinea.common.annotation.KaistineaResourceServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@KaistineaResourceServer
public class PasteApplication {
    public static void main(String[] args) {
        SpringApplication.run(PasteApplication.class, args);
    }
}
