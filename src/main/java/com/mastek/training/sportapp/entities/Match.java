package com.mastek.training.sportapp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Entity
@Table(name = "JPA_MATCH")
@NamedQueries({
	@NamedQuery(name = "Department.findByCompetition",
	 query = "select m from Match m where m.competition = :competition")})
public class Match {
	@Value("-1")
	private int matchno;
	@Value("Default Match")
	private String location;
	@Value("Default Competition")
	private String competition;
	private Set<Player> team = new HashSet<>();
	
	//mappedBY: Check the configuration for Many to Many associations 
	//in employee class getAssignments() method
	@ManyToMany(mappedBy = "competitions")
	public Set<Player> getTeam() {
		return team;
	}

	public void setTeam(Set<Player> team) {
		this.team = team;
	}

	public Match() {
		System.out.println("Match Created");
	}
	
	@Id
	@Column(name = "match_number") 
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getMatchno() {
		return matchno;
	}
	public void setMatchno(int matchno) {
		this.matchno = matchno;
	}
	
	@Column(name = "match_location", nullable=false, length = 45)
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCompetition() {
		return competition;
	}
	public void setCompetition(String competition) {
		this.competition = competition;
	}
	@Override
	public String toString() {
		return "Match [matchno=" + matchno + ", location=" + location + ", competition=" + competition + "]";
	}
}


