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

import com.example.projectpet.model.Inquire;
import com.example.projectpet.model.InquireDAO;

@CrossOrigin("*")
@RestController
public class InquireController {
	@Autowired
	private InquireDAO dao;
	
	@GetMapping("/inquire")
	public List<Inquire> getAllInquires() {
		return dao.findAll();
	}
	
	@GetMapping("/inquire/{id}")
	public Inquire getInquire(@PathVariable Integer id) {
		return dao.findByinquireId(id);
	}
	
	@PostMapping("/inquire")
	public ResponseEntity<String> addInquire(@RequestBody Inquire inq) {
		dao.save(inq);
		return ResponseEntity.status(HttpStatus.CREATED).body("新增成功");
	}
	
	@PutMapping("/inquire/{id}")
	public ResponseEntity<String> updateInquire(@PathVariable Integer id, @RequestBody Inquire inq) {
		if (dao.findByinquireId(id) != null) {
			dao.save(inq);
			return ResponseEntity.ok().body("修改成功");
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/inquire/{id}")
	public ResponseEntity<String> deleteInquire(@PathVariable Integer id) {
		if (dao.findByinquireId(id)!=null) {
			dao.deleteById(id);
			return ResponseEntity.ok().body("刪除成功");
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
