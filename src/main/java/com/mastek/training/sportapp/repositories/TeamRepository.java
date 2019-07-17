package com.mastek.training.sportapp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.mastek.training.sportapp.entities.Team;

@Component 
public interface TeamRepository extends CrudRepository <Team, Integer> {
	public List<Team> findByLeague(
			@Param("league") String league);
}
