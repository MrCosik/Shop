package com.example.gamesws.service;

import com.example.gamesws.dto.GameDTO;
import com.example.gamesws.entity.Game;

import java.util.List;

public interface GameService {

    GameDTO getGameByName(String name);
    List<GameDTO> getAllGames();
}
