package com.example.gameOfCricket.service;

import com.example.gameOfCricket.model.Batsman;
import com.example.gameOfCricket.repository.BatsmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BatsmanService {
    @Autowired
    BatsmanRepository batsmanRepository;
    public List<Batsman> getAll()
    {
        return batsmanRepository.findAll();
    }
    public List<Batsman> getAllBatsmanByTeamName(String teamName)
    {
        return batsmanRepository.findByTeamName(teamName);
    }
    public Batsman getBatsmanByName(String name)
    {
        Optional<Batsman> batsman=batsmanRepository.findByName(name);
        if(batsman.isPresent())
        return batsman.get();
        return new Batsman("virat","India");
    }
    public Batsman getBatsmanById(Long id)
    {
        Optional<Batsman> batsman=batsmanRepository.findById(id);
        if(batsman.isPresent())
            return batsman.get();
        return new Batsman("virat","India");
    }
    public void updateScoreOfBatsman(Long id,int score)
    {
        Optional <Batsman> batsman=batsmanRepository.findById(id);
        if(batsman.isPresent())
        {
            batsman.get().setTotalRunsScored(batsman.get().getTotalRunsScored()+score);
            batsmanRepository.save(batsman.get());
        }


    }
    public void updateTotalMatchesPlayed(Long id)
    {
        Optional <Batsman> batsman=batsmanRepository.findById(id);
        if(batsman.isPresent())
        {
            batsman.get().setTotalMatchesPlayed(batsman.get().getTotalMatchesPlayed()+1);
            batsmanRepository.save(batsman.get());
        }
    }
    public void addBatsman(Batsman batsman)
    {
        batsmanRepository.save(batsman);
    }
}
