package com.example.projectpet.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberDAO extends JpaRepository<Member, Integer> {

	Member findBymemberId(Integer id);

}
