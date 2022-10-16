package com.example.gamesws;

import com.example.gamesws.entity.Game;
import com.example.gamesws.repository.GameRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@EnableEurekaClient
@SpringBootApplication
public class GamesWsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GamesWsApplication.class, args);
    }



//    @Bean
//    CommandLineRunner init (GameRepository gameRepository){
//        return args -> {
//            Game g1 = new Game();
//            Game g2 = new Game();
//
//
//            g1.setName("The Witcher 3: Wild Hunt");
//            g1.setCopies(4);
//            g1.setPrice(49.99);
//
//            g2.setName("Cyberpunk 2077");
//            g2.setCopies(10);
//            g2.setPrice(59.99);
//
//            gameRepository.saveAll(Arrays.asList(g1, g2));
//        };
//    }

}
