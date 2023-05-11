package com.example.gameOfCricket.model;

import com.example.gameOfCricket.service.BatsmanService;
import com.example.gameOfCricket.service.BowlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Inning {


    public static void  startInning(List<Integer> team1, List<Integer> team2, List<Integer> scoreofTeam1) {




        Set<Integer> set = new HashSet<Integer>();
        int overs = 2;
        int balls = 0;
        int player1 = 0, player2 = 1;
        while (balls < overs * 6 && player1 < 11 && player2 < 11) {
            if (set.contains(player1)) {
                player1++;
                continue;
            }
            if (set.contains(player2)) {
                player2++;
                continue;
            }
            if (player1 == player2) {
                player1++;
                continue;
            }

            int score = (int) (Math.random() * 6);
            scoreofTeam1.set(player1, scoreofTeam1.get(player1) + score);
            balls++;
            if (score == 5) {
                set.add(player1);
                player1++;
                continue;
            }


            if (score % 2 == 1) {
                int temp = player1;
                player1 = player2;
                player2 = temp;
            }
        }
    }
}
