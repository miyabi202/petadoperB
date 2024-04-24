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

import com.example.projectpet.model.Application;
import com.example.projectpet.model.ApplicationDAO;

@CrossOrigin("*")
@RestController
public class ApplicationController {
	
	@Autowired
	private ApplicationDAO dao;
	
	@GetMapping("/appform")
	public List<Application> getAllAppForm() {
		return dao.findAll();
	}
	
	//return Optional.empty if not found, and responds "null" to browser.
	//return Optional[Application] if found, and responds it in JSON format to browser.
	//dao.findById() return type is Optional, but I need Application type. Use stream().filter to change its type.
	@GetMapping("/appform/{id}")
	public List<Application> findAppFormById(@PathVariable("id") Integer id) {
//		Application findApp = dao.findById(id).stream().filter(e -> e.getAlcId().equals(id)).findAny().orElse(null);
//		return findApp;
		return dao.queryById2(id);
	}
	
	@PostMapping("/appform")
	public ResponseEntity<String>  addAppForm(@RequestBody Application app) {
		dao.save(app);
		return ResponseEntity.status(HttpStatus.CREATED).body("新增成功");
	}
	
	@PutMapping("/appform/{id}")
	public ResponseEntity<String> updateAppForm(@PathVariable Integer id, @RequestBody Application app) {
		Application findform = dao.findById(id).stream().filter(e -> e.getAlcId().equals(id)).findAny().orElse(null);
		if (findform != null) {
			dao.save(app);
			return ResponseEntity.ok().body("修改成功");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/appform/{id}")
	public ResponseEntity<String> deleteAppForm(@PathVariable Integer id) {
		Application findform = dao.findById(id).stream().filter(e -> e.getAlcId().equals(id)).findAny().orElse(null);
		if (findform != null) {
			dao.deleteById(id);
			return ResponseEntity.ok().body("刪除成功");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
