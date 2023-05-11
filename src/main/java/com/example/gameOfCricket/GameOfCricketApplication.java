package com.example.gameOfCricket;


import com.example.gameOfCricket.model.Batsman;
import com.example.gameOfCricket.model.Bowler;
import com.example.gameOfCricket.model.Match;
import com.example.gameOfCricket.model.ScoreCard;
import com.example.gameOfCricket.repository.BowlerRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


import java.util.ArrayList;
import java.util.List;

@RestController
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "GameOfCricket",version = "1.0"))
@EnableWebMvc
@EnableElasticsearchRepositories(basePackages = "com.example.gameOfCricket.repository")


public class GameOfCricketApplication {

	public static void main(String[] args) {

		SpringApplication.run(GameOfCricketApplication.class, args);


	}
    @GetMapping("/startMatch/{team1Name}/{team2Name}")
    public List<List<String>> startMatch(@PathVariable String team1Name, @PathVariable String team2Name)
	{
		Match match =new Match(team1Name,team2Name);
		List<Integer> team1=new ArrayList<>();
		List<Integer> team2=new ArrayList<>();
		WebClient client = WebClient.create();


		List<Batsman> batsmanList = (List<Batsman>) client.get()
				.uri("http://localhost:8080/batsman/getAll/"+team1Name)
				.retrieve().bodyToMono(new ParameterizedTypeReference<List<Batsman>>(){}).block();
	for(int i=0;i<batsmanList.size();i++) team1.add(Math.toIntExact(batsmanList.get(i).getId()));
		 batsmanList = (List<Batsman>) client.get()
				.uri("http://localhost:8080/batsman/getAll/"+team2Name)
				.retrieve().bodyToMono(new ParameterizedTypeReference<List<Batsman>>(){}).block();
		for(int i=0;i<batsmanList.size();i++)
			team2.add(Math.toIntExact(batsmanList.get(i).getId()));
		List<Bowler>  bowlerList= (List<Bowler>) client.get()
				.uri("http://localhost:8080/bowler/getAll/"+team1Name)
				.retrieve().bodyToMono(new ParameterizedTypeReference<List<Bowler>>(){}).block();
		for(int i=0;i<bowlerList.size();i++)
			team1.add(Math.toIntExact(bowlerList.get(i).getId()));
		  bowlerList= (List<Bowler>) client.get()
				.uri("http://localhost:8080/bowler/getAll/"+team2Name)
				.retrieve().bodyToMono(new ParameterizedTypeReference<List<Bowler>>(){}).block();
		for(int i=0;i<bowlerList.size();i++)
			team2.add(Math.toIntExact(bowlerList.get(i).getId()));

		ScoreCard scoreCard=new ScoreCard(team1,team2);
		match.setId(scoreCard.getId());
		List<List<String>> ans=new ArrayList<>();

		List<Integer> scoreList=scoreCard.getScoreOfTeam1();
		List<String > temp=new ArrayList<>();
		for(int i=0;i<team1.size();i++)
		{
			if(i<6)
			{
				Batsman batsman = (Batsman) client.get()
						.uri("http://localhost:8080/batsman/getBatsmanById/"+team1.get(i))
						.retrieve().bodyToMono(Batsman.class).block();
				client.get()
						.uri("http://localhost:8080/batsman/updateScore/"+team1.get(i)+"/"+scoreList.get(i))
						.retrieve().bodyToMono(void.class).block();
				temp.add(batsman.getName()+"  "+scoreList.get(i));


			}
			else
			{
				Bowler bowler = (Bowler) client.get()
						.uri("http://localhost:8080/bowler/getBowlerById/"+team1.get(i))
						.retrieve().bodyToMono(Bowler.class).block();
				client.get()
						.uri("http://localhost:8080/bowler/updateScore/"+team1.get(i)+"/"+scoreList.get(i))
						.retrieve().bodyToMono(void.class).block();
				temp.add(bowler.getName()+"  "+scoreList.get(i));

			}
		}
		ans.add(temp);
		List<String > temp1=new ArrayList<>();
		 scoreList=scoreCard.getScoreOfTeam2();
		for(int i=0;i<team1.size();i++)
		{
			if(i<6)
			{
				Batsman batsman = (Batsman) client.get()
						.uri("http://localhost:8080/batsman/getBatsmanById/"+team2.get(i))
						.retrieve().bodyToMono(Batsman.class).block();
				client.get()
						.uri("http://localhost:8080/batsman/updateScore/"+team2.get(i)+"/"+scoreList.get(i))
						.retrieve().bodyToMono(void.class).block();
				temp1.add(batsman.getName()+"  "+scoreList.get(i));


			}
			else
			{
				Bowler bowler = (Bowler) client.get()
						.uri("http://localhost:8080/bowler/getBowlerById/"+team2.get(i))
						.retrieve().bodyToMono(Bowler.class).block();
				client.get()
						.uri("http://localhost:8080/bowler/updateScore/"+team2.get(i)+"/"+scoreList.get(i))
						.retrieve().bodyToMono(void.class).block();
				temp1.add(bowler.getName()+"  "+scoreList.get(i));

			}
		}
		ans.add(temp1);
		return ans;




	}

}
