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

import com.mastek.training.sportapp.apis.MatchService;
import com.mastek.training.sportapp.entities.Match;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MatchApplicationTests {
	
	@Autowired
	MatchService matchService;
	
	@Autowired
	Match match;
	
	@Test 
	public void addMatchUsingService() {
		match.setMatchno(0);
		match.setLocation("Leeds");
		match.setCompetition("League Cup");
		match = matchService.registerOrUpdateMatch(match);
		assertNotNull(match);
	}
	
	@Test
	public void findByMatchnoUsingService() {
		int matchno = 1;
		assertNotNull(matchService.findByMatchno(matchno));
	}
	
//	@Test
//	public void deleteByMatchnoUsingService() {
//		int matchno = 42;
//		matchService.deleteByMatchno(matchno);
//		assertNull(matchService.findByMatchno(matchno));
//	}
	
	@Test
	public void checkFetchByCompetition() {
		List<Match> matches = matchService.fetchMatchesByCompetition("League Cup");
		for (Match match : matches) {
			System.out.println(match);
		}
		assertEquals(matches.size(),1);
	}
	
	@Test
	public void simpleTest() {
		System.out.println("System Test Executed");
	}
}
