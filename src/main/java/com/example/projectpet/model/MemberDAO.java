package com.example.projectpet.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberDAO extends JpaRepository<Member, Integer> {
	
	Member findBymemberId(Integer id);

	
//yana added on 20240424
	    // 根據會員ID查找會員
	    Member findByMemberId(Integer id);

	    // 根據用戶名和密碼查找會員
	    Member findByUsernameAndPassword(String username, String password);

	    Member findByUsername(String usrname);
	    
	    

}
