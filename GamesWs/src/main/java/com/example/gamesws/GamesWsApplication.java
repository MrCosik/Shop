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

}
