package com.example.projectpet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectpet.model.Member;
import com.example.projectpet.model.MemberDAO;

@CrossOrigin("*")
@RestController
public class MemberController {
	@Autowired
	private MemberDAO dao;
	
	@GetMapping("/member")
	public List<Member> getAllMembers() {
		return dao.findAll();
	}
	
	@GetMapping("/member/{id}")
	public Member getMember(@PathVariable Integer id) {
		return dao.findBymemberId(id);
	}
	
	@PostMapping("/member")
	public ResponseEntity<String> addMember(@RequestBody Member member) {
//		Integer id = member.getMemberId();
//		Member findMember = dao.findById(id).stream().filter(e->e.getMemberId().equals(id)).findAny().orElse(null);
//		if (findMember != null) {
//			return null;
//		}else {
//			dao.save(member);
//			return dao.findAll();
//		}
		dao.save(member);
		return ResponseEntity.status(HttpStatus.CREATED).body("新增成功");
	}
	
	@PutMapping("/member/{id}")
	public ResponseEntity<String> updateMember(@PathVariable Integer id, @RequestBody Member member) {
		Member findMember = dao.findById(id).stream().filter(e->e.getMemberId().equals(id)).findAny().orElse(null);
		if (findMember != null) {
			dao.save(member);
			return ResponseEntity.ok().body("修改成功");
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/member/{id}")
	public ResponseEntity<String> deleteMember(@PathVariable Integer id) {
		Member findMember = dao.findById(id).stream().filter(e->e.getMemberId().equals(id)).findAny().orElse(null);
		if (findMember != null) {
			dao.deleteById(id);
			return ResponseEntity.ok().body("刪除成功");
		}else {
			return ResponseEntity.notFound().build();
		}
	}

}
