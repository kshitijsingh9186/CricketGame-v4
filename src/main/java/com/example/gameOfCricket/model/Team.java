package com.example.gameOfCricket.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ValueGenerationType;

@Entity@Getter@Setter
public class Team {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String teamName;

    public Team() {
    }

    public Team(String teamName) {
        this.teamName = teamName;
    }
}
