package com.example.gamesws.service;

import com.example.gamesws.dto.GameDTO;
import com.example.gamesws.dto.GamesDTO;
import com.example.gamesws.dto.UpdateGameDTO;
import com.example.gamesws.entity.Game;
import com.example.gamesws.repository.GameRepository;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService{

    private GameRepository repository;
    private RabbitTemplate rabbitTemplate;

    public GameServiceImpl(GameRepository repository, RabbitTemplate rabbitTemplate) {
        this.repository = repository;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.routingkey}")
    private String routingkey;

    @Override
    public GameDTO getGameByName(String name) {
        ModelMapper modelMapper = new ModelMapper();
        Game game = repository.findByName(name);
        return modelMapper.map(game, GameDTO.class);
    }

    @Override
    public List<GameDTO> getAllGames() {
        ModelMapper modelMapper = new ModelMapper();

        List<Game> allGames = repository.findAll();


        return allGames.stream().map(e -> modelMapper.map(e, GameDTO.class)).collect(Collectors.toList());
    }

    @Override
    public GameDTO updateGame(UpdateGameDTO updatedGame, Long id) {
        ModelMapper modelMapper = new ModelMapper();


        Game game = repository.findById(id).get();
        game.setName(updatedGame.getName());
        game.setPrice(updatedGame.getPrice());
        return modelMapper.map(repository.save(game), GameDTO.class);

    }

    public void buyGames(GamesDTO gameIds) {
        rabbitTemplate.convertAndSend(exchange,routingkey, gameIds);
    }
}
