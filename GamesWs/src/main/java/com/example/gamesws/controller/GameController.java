package com.example.gamesws.controller;

import com.example.gamesws.dto.GameDTO;
import com.example.gamesws.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class GameController {

    private GameService gameService;


    @GetMapping("/games")
    private ResponseEntity<List<GameDTO>> getAllGames(){
        return ResponseEntity.ok(gameService.getAllGames());
    }

    @GetMapping("/games/{gameName}")
    private ResponseEntity<GameDTO> getGame(@PathVariable String gameName){
        return ResponseEntity.ok(gameService.getGameByName(gameName));
    }
}
