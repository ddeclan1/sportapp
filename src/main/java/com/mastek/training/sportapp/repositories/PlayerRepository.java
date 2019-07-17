package com.mastek.training.sportapp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.mastek.training.sportapp.entities.Player;

@Component 
public interface PlayerRepository extends CrudRepository<Player, Integer>{
	public List<Player> findByPosition(
			@Param("position") String position);
}
