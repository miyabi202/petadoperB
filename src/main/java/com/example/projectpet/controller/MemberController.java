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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectpet.model.Employee;
import com.example.projectpet.model.Member;
import com.example.projectpet.model.MemberDAO;

import jakarta.servlet.http.HttpSession;

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
	
////20240424 yana added

	@PostMapping("/Membersingup") // 處理 POST 請求的端點
    public ResponseEntity<String> signUp(@RequestBody Member member) {
        // 檢查用戶名是否已存在於資料庫中，如果不存在則保存新用戶
        Member existingMember =dao.findByUsernameAndPassword(member.getUsername(), member.getPassword());
        if (existingMember != null) {
            return ResponseEntity.badRequest().body("Username already exists");
        } else {
            dao.save(member);
            return ResponseEntity.status(HttpStatus.CREATED).body("Sign up successful");
        }
    }

	
	 @PostMapping("/login")
	    public ResponseEntity<String> login(@RequestBody Member member, HttpSession session) {
	        // 根據用戶名稱查詢用戶訊息
	        Member existingMember = dao.findByUsername(member.getUsername());
	        if (existingMember != null) {
	            // 檢查密碼是否匹對（相同）
	            if (existingMember.getPassword().equals(member.getPassword())) {
	                // 登錄成功，將用戶訊息存在Session中
	                session.setAttribute("user", existingMember);
	                return ResponseEntity.status(HttpStatus.OK).body("index.html");
	            } else {
	                // 密碼不正確則返回錯誤訊息
	                return ResponseEntity.badRequest().body("Incorrect password");
	            }
	        } else {
	            // 用戶不存則返回錯誤訊息
	            return ResponseEntity.badRequest().body("User does not exist");
	        }
	    }

	    // 登出端口
	    @GetMapping("/logout")
	    public ResponseEntity<String> logout(HttpSession session) {
	        // 移除 Session 中用戶訊息
	        session.removeAttribute("user");
	        return ResponseEntity.ok().body("Logout successful");}
	        
	        
	        
	
	
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
