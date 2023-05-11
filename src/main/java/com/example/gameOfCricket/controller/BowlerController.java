package com.example.gameOfCricket.controller;

import com.example.gameOfCricket.model.Batsman;
import com.example.gameOfCricket.model.Bowler;
import com.example.gameOfCricket.service.BowlerService;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bowler")
public class BowlerController {
    @Autowired
    private BowlerService bowlerService;
    @GetMapping("/getAll")
    public List<Bowler> getAll()
    {
        return bowlerService.getAll();
    }
    @PostMapping("/add")
    public ResponseEntity<String> addBowler(@RequestBody Bowler bowler)
    {
        bowlerService.addBowler(bowler);
        return new ResponseEntity<>("Bowler Added", HttpStatus.OK);
    }
    @GetMapping("/getBowlerById/{id}")
    public Bowler getBowlerById(@PathVariable Long id)
    {
        return bowlerService.getBowlerById(id);
    }
    @GetMapping("/getAll/{teamName}")
    public List<Bowler> getAllBatsmanByTeamName(@PathVariable String teamName)
    {
        return bowlerService.getAllBowlerByTeamName(teamName);
    }
    @GetMapping("/updateScore/{id}/{score}")
    public void updateScoreOfBowler(@PathVariable Long id,@PathVariable int score)
    {
        bowlerService.updateScore(id,score);
        bowlerService.updateTotalMatchesPlayed(id);
    }
}
