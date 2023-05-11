package com.example.gameOfCricket.repository;

import com.example.gameOfCricket.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match,Long> {
}
