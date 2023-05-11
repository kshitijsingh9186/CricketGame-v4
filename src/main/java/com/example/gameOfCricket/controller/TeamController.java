package com.example.gameOfCricket.controller;

import com.example.gameOfCricket.model.Team;
import com.example.gameOfCricket.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {
    @Autowired
    private TeamService teamService;
    @GetMapping("/getAll")
    public List<Team> getAll()
    {
        return teamService.getAll();
    }
    @PostMapping("/add")
    public ResponseEntity addTeam(@RequestBody Team team)
    {
        teamService.addTeam(team);
        return new ResponseEntity("Team Added", HttpStatus.OK);
    }
}
