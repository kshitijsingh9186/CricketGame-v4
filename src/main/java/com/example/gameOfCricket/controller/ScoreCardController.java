package com.example.gameOfCricket.controller;

import com.example.gameOfCricket.model.ScoreCard;
import com.example.gameOfCricket.service.ScoreCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scoreCard")
public class ScoreCardController {
//    @Autowired
//    private ScoreCardService scoreCardService;
//    @GetMapping("/getAll")
//    public List<ScoreCard> getAll()
//    {
//        return scoreCardService.getAll();
//    }
//    @PostMapping("/add")
//    public ResponseEntity<String> addScoreCard(@RequestBody ScoreCard scoreCard)
//    {
//        scoreCardService.addScoreCard(new ScoreCard());
//        return new ResponseEntity<>("ScoreCard added", HttpStatus.OK);
//    }

}
