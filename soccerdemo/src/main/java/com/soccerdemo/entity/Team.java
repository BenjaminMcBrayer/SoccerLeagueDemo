package com.soccerdemo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.soccerdemo.entity.Member;

@Entity
@Table(name = "teams")
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long teamid;
	private String teamname;

	@OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Member> members = new ArrayList<>();

	public Team() {
	}

	public Team(Long teamid, String teamname, List<Member> members) {
		this.teamid = teamid;
		this.teamname = teamname;
		this.members = members;
	}

	public Team(String teamname, List<Member> members) {
		this.teamname = teamname;
		this.members = members;
	}

	// Constructor for creating a new team without any members.
	public Team(String teamname) {
		this.teamname = teamname;
	}

	public Long getTeamid() {
		return teamid;
	}

	public void setTeamid(Long teamid) {
		this.teamid = teamid;
	}

	public String getTeamname() {
		return teamname;
	}

	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	@Override
	public String toString() {
		return ("Team: " + this.getTeamname() + "Members: " + this.getMembers());
	}

	public void addMember(Member member) {
		members.add(member);
		member.setTeam(this);
	}

	public void removeMember(Member member) {
		members.remove(member);
		member.setTeam(null);
	}
}
