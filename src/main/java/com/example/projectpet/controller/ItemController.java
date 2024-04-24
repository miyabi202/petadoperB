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

import com.example.projectpet.model.Item;
import com.example.projectpet.model.ItemDAO;

@CrossOrigin("*")
@RestController
public class ItemController {
	@Autowired
	private ItemDAO dao;
	
	@GetMapping("/item")
	public List<Item> getAllItems() {
		return dao.findAll();
	}
	
	@GetMapping("/item/{id}")
	public Item getItemById(@PathVariable Integer id) {
		return dao.queryByitemId(id);
	}
	
	@PostMapping("/item")
	public ResponseEntity<String> addItem(@RequestBody Item item) {
		dao.save(item);
		return ResponseEntity.status(HttpStatus.CREATED).body("新增成功");
	}
	
	@PutMapping("/item/{id}")
	public ResponseEntity<String> updateItem(@PathVariable Integer id, @RequestBody Item item) {
		Item findItem = dao.findById(id).stream().filter(e->e.getItemId().equals(id)).findAny().orElse(null);
		if (findItem != null) {
			dao.save(item);
			return ResponseEntity.ok().body("修改成功");
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/item/{id}")
	public ResponseEntity<String> updateItem(@PathVariable Integer id) {
		Item findItem = dao.findById(id).stream().filter(e->e.getItemId().equals(id)).findAny().orElse(null);
		if (findItem != null) {
			dao.deleteById(id);
			return ResponseEntity.ok().body("刪除成功");
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
