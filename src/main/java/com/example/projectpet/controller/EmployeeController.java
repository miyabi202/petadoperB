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
import com.example.projectpet.model.EmployeeDAO;

import jakarta.servlet.http.HttpSession;

@CrossOrigin("*")
@RestController
public class EmployeeController {
	@Autowired
	private EmployeeDAO dao;
	
	@GetMapping("/employee")
	public List<Employee> getAllEmployees() {
		return dao.findAll();
	}
	
	@GetMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable Integer id) {
		return dao.findByempId(id);
	}
	
	@PostMapping("/employee")
	public ResponseEntity<String> addEmployee(@RequestBody Employee emp) {
//		Integer id = emp.getEmpId();
//		Employee findEmp = dao.findById(id).stream().filter(e->e.getEmpId().equals(id)).findAny().orElse(null);
//		if (findEmp != null) {
//			return null;
//		}else {
//			dao.save(emp);
//			return dao.findAll();
//		}
		dao.save(emp);
		return ResponseEntity.status(HttpStatus.CREATED).body("新增成功");
	}
	
	@PostMapping("/empcheck")
	public ResponseEntity<String> findUser(@RequestParam("name") String name, @RequestParam("password") String password) {
    	Employee e=dao.findByUsernameAndPassword(name, password);
    	if(e!=null) {
    		//session.setAttribute("loginUser", e);
    		return ResponseEntity.ok().body("Valid");
    	}else {
    		return ResponseEntity.notFound().build();
    	}
	}
	
	@PutMapping("/employee/{id}")
	public ResponseEntity<String> addEmployee(@PathVariable Integer id, @RequestBody Employee emp) {
		Employee findEmp = dao.findById(id).stream().filter(e->e.getEmpId().equals(id)).findAny().orElse(null);
		if (findEmp != null) {
			dao.save(emp);
			return ResponseEntity.ok().body("修改成功");
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer id) {
		Employee findEmp = dao.findById(id).stream().filter(e->e.getEmpId().equals(id)).findAny().orElse(null);
		if (findEmp != null) {
			dao.deleteById(id);
			return ResponseEntity.ok().body("刪除成功");
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
