package com.example.gamesws.service;

import com.example.gamesws.dto.GameDTO;
import com.example.gamesws.dto.GamesDTO;
import com.example.gamesws.dto.UpdateGameDTO;

import java.util.List;

public interface GameService {

    GameDTO getGameByName(String name);
    List<GameDTO> getAllGames();
    GameDTO updateGame(UpdateGameDTO updatedGame, Long id);
     void buyGames(GamesDTO gameIds);
}
