package com.keypopsh.cringebot;

import com.keypopsh.cringebot.config.CringeBotConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(CringeBotConfig.class)
public class CringebotApplication {

    public static void main(String[] args) {
        SpringApplication.run(CringebotApplication.class, args);
    }

}
