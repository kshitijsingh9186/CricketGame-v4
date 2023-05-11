package com.example.gameOfCricket.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity@Getter@Setter
public class Match {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;


    private String team1Name;

   private String  team2Name;

    int finalScoreCard;

    public Match(String team1Name, String team2Name) {
        this.team1Name = team1Name;
        this.team2Name = team2Name;
    }
}
