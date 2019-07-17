package com.mastek.training.sportapp.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.training.sportapp.entities.Player;
import com.mastek.training.sportapp.repositories.PlayerRepository;

@Component
@Scope("singleton")
public class PlayerService {
	
	@Autowired
	private PlayerRepository playerRepository;
	
	public PlayerService() {
		System.out.println("Player Service Created");
	}

	public Player registerOrUpdatePlayer(Player player) {
		player = playerRepository.save(player);
		System.out.println("Player Registered" + player);
		return player;
	}

	public Player findByPlayerid(int playerid) {
		try {
			return playerRepository.findById(playerid).get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Player> fetchPlayersByPosition(String position){
		return playerRepository.findByPosition(position);
	}
	
	public void deleteByPlayerid(int playerid) {
		playerRepository.deleteById(playerid);
	}
}
