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

import com.example.projectpet.model.Pet;
import com.example.projectpet.model.PetDAO;

@CrossOrigin("*")
@RestController
public class PetController {

	@Autowired
	private PetDAO dao;

	@GetMapping("/pet")
	public ResponseEntity<List<Pet>> getAllPets() {
		List<Pet> pets = dao.findAll();
		return ResponseEntity.ok().body(pets);
	}

	@GetMapping("/pet/{id}")
	public Pet findPetById(@PathVariable("id") Integer id) {
		return dao.queryById(id);
	}
	
//	@GetMapping("/pet/{name}")
//	public Pet findPetByName(@PathVariable("name") String name) {
//		return dao.findByName(name);
//	}

	@GetMapping("/pet/{sex}/{species}")
	public List<Pet> findPetByNameOrSpecies(@PathVariable("sex") String sex, @PathVariable("species") String species) {
		return dao.findBySexAndSpecies(sex, species);
	}

	@GetMapping("/pet/byspecies/{species}")
	public List<Pet> findBySpecies(@PathVariable("species") String species) {
		return dao.findBySpecies(species);
	}

	//前端在送Pet資料時，內容不用帶ID，因為資料庫的ID欄位是用AI
	@PostMapping("/pet")
	public ResponseEntity<String> addPet(@RequestBody Pet pet) {
		dao.save(pet);
		return ResponseEntity.status(HttpStatus.CREATED).body("新增成功");
	}

	@PutMapping("/pet/{id}")
	public ResponseEntity<String> updatePet(@PathVariable Integer id, @RequestBody Pet pet) {
		//Pet findPet = dao.findById(id).stream().filter(e -> e.getPetId().equals(id)).findAny().orElse(null);
		Optional<Pet> findPet = dao.findById(id);
		//if (findPet != null) {
		if (findPet.isPresent()) {
			dao.save(pet);
			return ResponseEntity.ok().body("修改成功");
		} else {
			return ResponseEntity.notFound().build();
			//return ResponseEntity.badRequest().body("找不到啦!");
			//https://segmentfault.com/a/1190000019891237
		}
	}

	@DeleteMapping("/pet/{id}")
	public ResponseEntity<String> deletePet(@PathVariable Integer id) {
		Pet findPet = dao.findById(id).stream().filter(e -> e.getPetId().equals(id)).findAny().orElse(null);
		if (findPet != null) {
			dao.deleteById(id);
			return ResponseEntity.ok().body("刪除成功");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
