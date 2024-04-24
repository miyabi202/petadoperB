package com.example.projectpet.controller;

import java.util.List;
import java.util.Optional;

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

import com.example.projectpet.model.Case;
import com.example.projectpet.model.CaseDAO;

@CrossOrigin("*")
@RestController
public class CaseController {
	
	@Autowired
	private CaseDAO dao;
	
	@GetMapping("/case")
	public List<Case> getAllCases() {
		return dao.findAll();
	}
	
	@GetMapping("/case/{id}")
	public Optional<Case> getCaseById(@PathVariable("id") Integer id) {
		return dao.findById(id);		
	}
	
	@PostMapping("/case")
	public ResponseEntity<String> addCase(@RequestBody Case newCase) {
		dao.save(newCase);
		return ResponseEntity.status(HttpStatus.CREATED).body("新增成功");
	}
	
	@PutMapping("/case/{id}")
	public ResponseEntity<String> updateCase(@PathVariable("id") Integer id, @RequestBody Case newCase) {
		Case findCase = dao.findById(id).stream().filter(e -> e.getCaseId().equals(id)).findAny().orElse(null);
		if (findCase != null) {
			dao.save(newCase);
			return ResponseEntity.ok().body("修改成功");
		} else {
			return ResponseEntity.notFound().build();
		}		
	}
	
	@DeleteMapping("/case/{id}")
	public ResponseEntity<String> deleteCase(@PathVariable("id") Integer id) {
		Case findCase = dao.findById(id).stream().filter(e -> e.getCaseId().equals(id)).findAny().orElse(null);
		if (findCase != null) {
			dao.deleteById(id);
			return ResponseEntity.ok().body("刪除成功");
		} else {
			return ResponseEntity.notFound().build();
		}		
	}
}
