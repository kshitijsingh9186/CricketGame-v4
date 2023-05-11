package com.example.gameOfCricket.service;

import com.example.gameOfCricket.model.Batsman;
import com.example.gameOfCricket.model.Bowler;
import com.example.gameOfCricket.repository.BowlerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.lang.model.element.Name;
import java.util.List;
import java.util.Optional;

@Service(value = "bowlerService")
public class BowlerService {
    @Autowired
    private BowlerRepository bowlerRepository;
    public List<Bowler> getAll()
    {
        return bowlerRepository.findAll();
    }
    public void addBowler(Bowler bowler)
    {
        bowlerRepository.save(bowler);
    }
    public Bowler getBowlerById(Long id)
    {
        Optional<Bowler> bowler=bowlerRepository.findById(id);
        return bowler.get();
    }
    public List<Bowler> getAllBowlerByTeamName(String teamName)
    {
        return bowlerRepository.getAllBowlerByTeamName(teamName);
    }
    public void updateScore(Long id,int score)
    {
        bowlerRepository.updateScore(id,score);
    }
    public void updateTotalMatchesPlayed(Long id)
    {
        bowlerRepository.updateTotalMatchesPlayed(id);
    }
    public void updateWicketsTaken(Long id,int wickets)
    {
        bowlerRepository.updateWicketsTaken(id,wickets);
    }
}
