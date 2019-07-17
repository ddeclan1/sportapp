package com.mastek.training.sportapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastek.training.sportapp.apis.TeamService;
import com.mastek.training.sportapp.apis.PlayerService;
import com.mastek.training.sportapp.apis.MatchService;
import com.mastek.training.sportapp.entities.Team;
import com.mastek.training.sportapp.entities.Player;
import com.mastek.training.sportapp.entities.Match;

//Initialise the JUnit test with Spring Boot application environment
//Spring Boot Test: Used to test Spring application context with all the test cases identified

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlayerApplicationTests {
	
	@Autowired
	TeamService teamService;
	
	@Autowired
	MatchService proService;
	
	//Scan all the components and provide the best match object in the component within memory
	@Autowired
	PlayerService playerService;
	
	@Autowired
	Player player;
	
	@Test 
	public void addPlayerUsingService() {
		player.setPlayerid(0);
		player.setName("Fred");
		player.setPosition("Striker");
		player = playerService.registerOrUpdatePlayer(player);
		assertNotNull(player);
	}
	
	@Test
	public void findByPlayeridUsingService() {
		int playerno = 1;
		assertNotNull(playerService.findByPlayerid(playerno));
	}
	
//	@Test
//	public void deleteByPlayeridUsingService() {
//		int playerid = 43;
//		playerService.deleteByPlayerid(playerid);
//		assertNull(playerService.findByPlayerid(playerid));
//	}
	
	@Test
	public void checkFetchByPosition() {
		List<Player> players = playerService.fetchPlayersByPosition("Striker");
		for (Player player : players) {
			System.out.println(player);
		}
		assertEquals(players.size(),1);
	}
	
	@Test
	public void manageAssociations() {
		Team t1 = new Team();
		t1.setName("Big Dogs");
		t1.setLeague("Animals");
		
		Player p1 = new Player();
		p1.setName("Bob");
		p1.setPosition("Goalkeeper");
		
		Player p2 = new Player();
		p2.setName("Adam");
		p2.setPosition("Defender");
		
		Match m1 = new Match();
		m1.setLocation("Manchester");
		m1.setCompetition("Wooden Sock");
		
		Match m2 = new Match();
		m2.setLocation("London");
		m2.setCompetition("Golden Spoon");
		
		t1.getMembers().add(p1);
		t1.getMembers().add(p2);
	
		p1.setCurrentTeam(t1);
		p2.setCurrentTeam(t1);
		
		//Many to Many
		p1.getCompetitions().add(m2);
		p1.getCompetitions().add(m1);
		p2.getCompetitions().add(m1);
		
		teamService.registerOrUpdateTeam(t1);
	}
	
	@Test
	public void simpleTest() {
		System.out.println("System Test Executed");
	}
}
