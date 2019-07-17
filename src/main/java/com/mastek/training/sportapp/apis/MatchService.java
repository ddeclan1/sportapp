package com.mastek.training.sportapp.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.training.sportapp.entities.Match;
import com.mastek.training.sportapp.repositories.MatchRepository;

@Component
@Scope("singleton")
public class MatchService {
	@Autowired
	private MatchRepository matchRepository;
	
	public MatchService() {
		System.out.println("Match Service Created");
	}

	public Match registerOrUpdateMatch(Match match) {
		match = matchRepository.save(match);
		System.out.println("Match Registered" + match);
		return match;
	}

	public Match findByMatchno(int matchno) {
		try {
			return matchRepository.findById(matchno).get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Match> fetchMatchesByCompetition(String competition){
		return matchRepository.findByCompetition(competition);
	}
	
	public void deleteByMatchno(int matchno) {
		matchRepository.deleteById(matchno);
	}
}

