package org.example.adapters;

import org.example.adapters.database.UserDB;
import org.example.adapters.database.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.stream.Stream;

@EntityScan(basePackages = {"org.example"})
@SpringBootApplication
//@EnableJpaRepositories
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository) {
        return args -> {
            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
                UserDB userDB = new UserDB(name, name.toLowerCase() + "@domain.com");
                userRepository.save(userDB);
            });
            userRepository.findAll().forEach(System.out::println);
        };
    }
}