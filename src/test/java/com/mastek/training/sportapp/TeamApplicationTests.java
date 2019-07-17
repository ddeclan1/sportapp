package com.mastek.training.sportapp;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastek.training.sportapp.apis.TeamService;
import com.mastek.training.sportapp.entities.Team;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TeamApplicationTests {

		@Autowired
		TeamService teamService;
		
		@Autowired
		Team team;
		
		@Test 
		public void addTeamUsingService() {
			team.setTeamid(0);
			team.setName("Fedora");
			team.setLeague("Flying Hats");
			team = teamService.registerOrUpdateTeam(team);
			assertNotNull(team);
		}
		
		@Test
		public void findByTeamidUsingService() {
			int teamno = 1;
			assertNotNull(teamService.findByTeamid(teamno));
		}
		
//		@Test
//		public void deleteByTeamidUsingService() {
//			int teamno = 39;
//			teamService.deleteByTeamid(teamno);
//			assertNull(teamService.findByTeamid(teamno));
//		}
		
		@Test
		public void checkFetchByLeague() {
			List<Team> teams = teamService.fetchTeamsByLeague("Flying Hats");
			for (Team team : teams) {
				System.out.println(team);
			}
			assertEquals(teams.size(),1);
		}
		
		@Test
		public void simpleTest() {
			System.out.println("System Test Executed");
		}
	}
