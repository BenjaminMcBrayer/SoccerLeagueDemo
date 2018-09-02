package com.soccerdemo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soccerdemo.entity.Member;
import com.soccerdemo.entity.Team;

@Repository
public interface MembersRepository extends JpaRepository<Member, Long> {

	Optional<Member> findByMembername(String membername);
	List<Member> findByTeam(Team team);

}
