package com.example.gamesws.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class GameDTO {
    private Long id;
    private String name;
    private Double price;
    private Integer copies;
}
