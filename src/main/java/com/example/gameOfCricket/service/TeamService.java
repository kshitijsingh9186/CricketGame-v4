package com.example.gameOfCricket.service;

import com.example.gameOfCricket.model.Team;
import com.example.gameOfCricket.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    @Autowired
    TeamRepository teamRepository;
    public List<Team> getAll()
    {
        return teamRepository.findAll();
    }
    public void addTeam(Team team)
    {
        teamRepository.save(team);
    }
}
