package com.soccerdemo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.soccerdemo.repo.MembersRepository;
import com.soccerdemo.repo.TeamsRepository;
import com.soccerdemo.entity.Member;
import com.soccerdemo.entity.Team;

@Controller
public class LeagueController {

	@Autowired
	MembersRepository mP;

	@Autowired
	TeamsRepository tP;

	// List all members.
	@RequestMapping("/memberadmin")
	public ModelAndView memberAdmin() {
		return new ModelAndView("memberadmin", "members", mP.findAll());
	}

	// List all teams.
	@RequestMapping("/teamadmin")
	public ModelAndView teamAdmin() {
		return new ModelAndView("teamadmin", "teams", tP.findAll());
	}

	// View member data (using @PathVariable).
	@RequestMapping(value = "/viewmember/{memberid}")
	public ModelAndView viewMember(@PathVariable("memberid") Long memberid) {
		Member member = mP.findById(memberid).orElse(null);
		ModelAndView mv = new ModelAndView("memberview");
		mv.addObject("title", "Member Information");
		mv.addObject("viewmember", member);
		mv.addObject("member", member);
		return mv;
	}

	// View team data (using @RequestParam).
	@RequestMapping(value = "/viewteam")
	public ModelAndView viewTeam(@RequestParam("teamid") Long teamid) {
		Team team = tP.findById(teamid).orElse(null);
		ModelAndView mv = new ModelAndView("teamview");
		mv.addObject("team", team);
		List<Member> members = team.getMembers();
		mv.addObject("members", members);
		return mv;
	}

	// Display form to update a member (using @RequestParam). 
	@RequestMapping("editmember")
	public ModelAndView showMemberEditForm(@RequestParam("memberid") Long memberid) {
		Optional<Member> optionalMember = mP.findById(memberid);
		Member member = optionalMember.get();
		return new ModelAndView("memberedit", "member", member);
	}

	// Submit member update form (using @RequestParam).
	@RequestMapping("memberedit")
	public ModelAndView submitMemberEditForm(@RequestParam("memberid") Long memberid,
			@RequestParam("membername") String membername, @RequestParam("memberrole") String memberrole,
			@RequestParam("teamid") Long teamid) {
		Optional<Team> optionalTeam = tP.findById(teamid);
		Team team = optionalTeam.get();
		Member member = new Member(memberid, membername, memberrole, team);
		mP.save(member);
		return new ModelAndView("redirect:/memberadmin");
	}
	
	// Display form to update a team (using @RequestParam).
	@RequestMapping(value = "/editteam")
	public ModelAndView editTeam(@RequestParam("teamid") Long teamid) {
		Optional<Team> optionalTeam = tP.findById(teamid);
		Team team = optionalTeam.get();
		return new ModelAndView("teamedit", "team", team);
	}

	// Submit team update form (using @RequestParam).
	@RequestMapping(value = "/teamedit")
	public ModelAndView updateTeam(@RequestParam("teamid") Long teamid, @RequestParam("teamname") String teamname,
			@RequestParam("members") List<Member> members) {
		Team team = new Team(teamid, teamname, members);
		tP.save(team);
		return new ModelAndView("redirect:/teamadmin");
	}

	// Delete a member.
	@RequestMapping(value = { "/deletemember" })
	public ModelAndView deleteMember(@RequestParam("memberid") Long memberid) {
		mP.deleteById(memberid);
		return new ModelAndView("redirect:/memberadmin");
	}

	// Delete a team.
	@RequestMapping(value = { "/deleteteam" })
	public ModelAndView deleteTeam(@RequestParam("teamid") Long teamid) {
		tP.deleteById(teamid);
		return new ModelAndView("redirect:/teamadmin");
	}
	
	// Display add member form.
	@RequestMapping("/addnewmember")
	public String addNewMember() {
		return "addnewmember";
	}
	
	// Submit add member form.
	@RequestMapping("/addmember")
	public ModelAndView addMember(@RequestParam("membername") String membername,
			@RequestParam("memberrole") String memberrole, @RequestParam("teamid") Long teamid) {
		Optional<Team> optionalTeam = tP.findById(teamid);
		Team team = optionalTeam.get();
		Member member = new Member(membername, memberrole, team);
		mP.save(member);
		return new ModelAndView("redirect:/memberadmin");
	}
	
	// Display add team form.
	@RequestMapping("/addnewteam")
	public String addNewTeam() {
		return "addnewteam";
	}

	// Submit add team form.
	@RequestMapping("/addteam")
	public ModelAndView addTeam(@RequestParam("teamname") String teamname) {
		Team team = new Team(teamname);
		tP.save(team);
		return new ModelAndView("redirect:/teamadmin");
	}
}
