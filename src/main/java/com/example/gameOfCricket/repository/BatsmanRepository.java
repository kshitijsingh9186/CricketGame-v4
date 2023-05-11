package com.example.gameOfCricket.repository;

import com.example.gameOfCricket.model.Batsman;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

@EnableElasticsearchRepositories
public interface BatsmanRepository extends ElasticsearchRepository<Batsman,Long> {

    List<Batsman> findAll();
    Optional<Batsman> findByName(String name);
    Optional<Batsman> findById(Long id);
    List<Batsman> findByTeamName(String TeamName);


}
