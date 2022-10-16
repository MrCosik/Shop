package com.example.gamesws.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table
public class Game {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Double price;
    private Integer copies;
}
