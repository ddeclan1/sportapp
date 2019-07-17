package com.mastek.training.sportapp.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Entity
@Table(name = "JPA_PlAYER") 
@NamedQueries({
	@NamedQuery(name = "Player.findByPosition",
	 query = "select p from Player p where p.position = :position")})
public class Player implements Serializable {
	@Value("-1")
	private int playerid;
	@Value("Default Player")
	private String name;
	@Value("Default Position")
	private String position;
	private Set<Match> competitions = new HashSet<>();
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
			name = "JPA_COMPETITIONS",
			joinColumns = @JoinColumn(name = "FK_PLAYERID"),
			inverseJoinColumns = @JoinColumn(name = "FK_MATCHNO")
	)
	
	public Set<Match> getCompetitions() {
		return competitions;
	}
	public void setCompetitions(Set<Match> competitions) {
		this.competitions = competitions;
	}
	private Team currentTeam;
	
	@ManyToOne
	@JoinColumn(name = "FK_TeamID")
	public Team getCurrentTeam() {
		return currentTeam;
	}

	public void setCurrentTeam(Team currentTeam) {
		this.currentTeam = currentTeam;
	}

	public Player() {
		System.out.println("Player Created");
	}
	
	@Id
	@Column(name = "player_number") 
	@GeneratedValue(strategy = GenerationType.AUTO) 
	public int getPlayerid() {
		return playerid;
	}
	public void setPlayerid(int playerid) {
		this.playerid = playerid;
	}
	
	@Column(name = "player_name", nullable = false, length = 45) 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "position", nullable = false, length = 45)
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	@Override
	public String toString() {
		return "Player [playerid=" + playerid + ", name=" + name + ", position=" + position + "]";
	}
}
