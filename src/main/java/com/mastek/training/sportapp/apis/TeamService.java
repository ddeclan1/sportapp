package com.mastek.training.sportapp.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.training.sportapp.entities.Team;
import com.mastek.training.sportapp.repositories.TeamRepository;

@Component
@Scope("singleton")
public class TeamService {
	@Autowired
	private TeamRepository teamRepository;
	
	public TeamService() {
		System.out.println("Team Service Created");
	}

	public Team registerOrUpdateTeam(Team team) {
		team = teamRepository.save(team);
		System.out.println("Team Registered" + team);
		return team;
	}

	public Team findByTeamid(int teamid) {
		try {
			return teamRepository.findById(teamid).get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Team> fetchTeamsByLeague(String league){
		return teamRepository.findByLeague(league);
	}
	
	public void deleteByTeamid(int teamid) {
		teamRepository.deleteById(teamid);
	}
}
