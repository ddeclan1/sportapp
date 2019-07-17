package com.mastek.training.sportapp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.mastek.training.sportapp.entities.Match;

@Component
public interface MatchRepository extends CrudRepository <Match, Integer>{
	public List<Match> findByCompetition(
			@Param("competition") String competition);

}
