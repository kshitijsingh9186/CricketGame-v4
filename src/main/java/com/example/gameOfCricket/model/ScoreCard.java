package com.example.gameOfCricket.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

 @Data
public class ScoreCard {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;

    List<Integer> team1=new ArrayList<>();
    List<Integer> team2=new ArrayList<>();
    List<Integer> scoreOfTeam1=new ArrayList<>();
    List<Integer> scoreOfTeam2=new ArrayList<>();

    public ScoreCard() {
        for(int i=0;i<11;i++)
        {
            scoreOfTeam1.add(0);
            scoreOfTeam2.add(0);
            team1.add(i);
            team2.add(i);
        }

        Inning.startInning(team1,team2,scoreOfTeam1);
        Inning.startInning(team2,team1,scoreOfTeam2);

    }

    public ScoreCard(List<Integer> team1, List<Integer> team2) {
        this.team1 = team1;
        this.team2 = team2;
        for(int i=0;i<11;i++)
        {
            scoreOfTeam1.add(0);
            scoreOfTeam2.add(0);
        }


        Inning inning=new Inning();
        inning.startInning(team1,team2,scoreOfTeam1);
        inning.startInning(team2,team1,scoreOfTeam2);

    }

}
