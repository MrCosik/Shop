package com.example.gamesws.repository;

import com.example.gamesws.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    Game findByName(String name);
}
