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

import com.example.projectpet.model.Order;
import com.example.projectpet.model.OrderDAO;

@CrossOrigin("*")
@RestController
public class OrderController {
	@Autowired
	private OrderDAO dao;
	
	@GetMapping("/order")
	public List<Order> getAllOrders() {
		return dao.findAll();
	}
	
	@GetMapping("/order/{id}")
	public Order getOrder(@PathVariable Integer id) {
		return dao.findByorderId(id);
	}
	
	@PostMapping("/order")
	public ResponseEntity<String> addOrder(@RequestBody Order order) {
		dao.save(order);
		return ResponseEntity.status(HttpStatus.CREATED).body("新增成功");
	}
	
	@PutMapping("/order/{id}")
	public ResponseEntity<String> updateOrder(@PathVariable Integer id, @RequestBody Order order) {
		if (dao.findByorderId(id)!=null) {
			dao.save(order);
			return ResponseEntity.ok().body("修改成功");
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/order/{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable Integer id) {
		if (dao.findByorderId(id)!=null) {
			dao.deleteById(id);
			return ResponseEntity.ok().body("刪除成功");
		}else {
			return ResponseEntity.notFound().build();
		}
	}

}
