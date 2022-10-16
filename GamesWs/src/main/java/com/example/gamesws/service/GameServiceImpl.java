package com.example.gamesws.service;

import com.example.gamesws.dto.GameDTO;
import com.example.gamesws.entity.Game;
import com.example.gamesws.repository.GameRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GameServiceImpl implements GameService{

    private GameRepository repository;

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
        List<GameDTO> mappedGames = allGames.stream().map(e -> modelMapper.map(e, GameDTO.class)).collect(Collectors.toList());


        return mappedGames;
    }
}
