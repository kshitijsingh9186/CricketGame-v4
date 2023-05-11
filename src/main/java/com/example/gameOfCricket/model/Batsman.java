package com.example.gameOfCricket.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "batsman")
@AllArgsConstructor
public class Batsman {
    @Id
    Long id;
    private String name;
    private String teamName;
    private int totalMatchesPlayed;
    private int totalRunsScored;


    public Batsman() {
        totalMatchesPlayed=0;
        totalRunsScored=0;

    }

    public Batsman(String name, String teamName) {
        this.name = name;
        this.teamName = teamName;
    }
}
