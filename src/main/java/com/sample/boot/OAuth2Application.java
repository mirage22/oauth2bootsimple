package com.sample.boot;

import com.sample.boot.repository.RoboUnitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Miro Wengner (@miragemiko)
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.sample.boot.repository")
public class OAuth2Application {
    public static void main(String[] args) {
        SpringApplication.run(OAuth2Application.class, args);
    }

    @Bean
    public CommandLineRunner runner(final RoboUnitRepository repository) {
        return (args) -> System.err.println(repository.findAll());
    }
}
