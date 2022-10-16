package com.example.gamesws.controller;

import com.example.gamesws.dto.GameDTO;
import com.example.gamesws.dto.GamesDTO;
import com.example.gamesws.dto.UpdateGameDTO;
import com.example.gamesws.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<GameDTO> getGame(@PathVariable String gameName){
        return ResponseEntity.ok(gameService.getGameByName(gameName));
    }

    @PostMapping("/game/{id}")
    public ResponseEntity<GameDTO> updateGame(@PathVariable Long id, @RequestBody UpdateGameDTO updatedGame){
        return ResponseEntity.ok(gameService.updateGame(updatedGame, id));
    }

    @PostMapping("/buy")
    public ResponseEntity<String> buyGames(@RequestBody GamesDTO gamesId){

        gameService.buyGames(gamesId);
        return ResponseEntity.ok("Order placed");
    }
}
