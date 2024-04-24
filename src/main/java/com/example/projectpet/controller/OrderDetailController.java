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
import com.example.projectpet.model.ODId;
import com.example.projectpet.model.Order;
import com.example.projectpet.model.OrderDetail;
import com.example.projectpet.model.OrderDetailDAO;

@CrossOrigin("*")
@RestController
public class OrderDetailController {
	@Autowired
	private OrderDetailDAO dao;
	
	@GetMapping("/od")
	public List<OrderDetail> getAllOD() {
		return dao.findAll();
	}
	
	//oId=orderId
	@GetMapping("/od/{oId}")
	public List<OrderDetail> getOD(@PathVariable Integer oId) {
		Order id = new Order(oId);
		return dao.findByorderId(id);
	}
	
	@PostMapping("/od")
	public ResponseEntity<String> addOD(@RequestBody OrderDetail od) {
		dao.save(od);
		return ResponseEntity.status(HttpStatus.CREATED).body("新增成功");
	}
	
	//只能更改數量和小計
	@PutMapping("/od/{oId}/{iId}")
	public ResponseEntity<String> updateOD(@PathVariable("oId") Integer oId, @PathVariable("iId") Integer iId, @RequestBody OrderDetail od) {
		Order id1 = new Order(oId);
		Item id2 = new Item(iId);
		if (dao.findByOrderIdAndItemId(id1, id2) != null) {
			dao.save(od);
			return ResponseEntity.ok().body("修改成功");
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//Delete by PK(ODId).
	@DeleteMapping("/od/{oId}/{iId}")
	public ResponseEntity<String> deleteOD(@PathVariable("oId") Integer oId, @PathVariable("iId") Integer iId) {
		Order id1 = new Order(oId);
		Item id2 = new Item(iId);
		ODId odId = new ODId(id1, id2);
		if (dao.findByOrderIdAndItemId(id1, id2) != null) {
			dao.deleteById(odId);
			return ResponseEntity.ok().body("刪除成功");
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
