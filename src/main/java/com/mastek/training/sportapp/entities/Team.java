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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Entity
@Table(name = "JPA_TEAM")
@NamedQueries({
	@NamedQuery(name = "Team.findByLeague",
	 query = "select t from Team t where t.league = :league")})
public class Team implements Serializable{
		@Value("-1")
		private int teamid;
		@Value("Default Team")
		private String name;
		@Value("Default League")
		private String league;
		private Set<Player> members = new HashSet<>();
	   
	    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy = "currentTeam")
		public Set<Player> getMembers() {
			return members;
		}

		public void setMembers(Set<Player> members) {
			this.members = members;
		}

		public Team() {
			System.out.println("Team Created");
		}
		
		@Id
		@Column(name = "team_id") 
		@GeneratedValue(strategy = GenerationType.AUTO)
		public int getTeamid() {
			return teamid;
		}
		public void setTeamid(int teamid) {
			this.teamid = teamid;
		}
		
		@Column(name = "team_name", nullable=false, length = 45)
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getLeague() {
			return league;
		}
		public void setLeague(String league) {
			this.league = league;
		}
		@Override
		public String toString() {
			return "Department [teamid=" + teamid + ", name=" + name + ", league=" + league + "]";
		}
	}

