package com.example.gameOfCricket.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter

public class Bowler {
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private Long id;
    private String name;
    private String teamName;
    private int totalMatchesPlayed;
    private int totalRunsScored;
    @Column
    int wicketsTaken;

    public Bowler() {
        this.wicketsTaken = 0;
    }
}
