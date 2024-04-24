package com.example.projectpet.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface PetDAO extends JpaRepository<Pet, Integer> {

	Pet findByName(String name);
	
    @Query(value = "select * from pets where petId = ?1", nativeQuery = true)
    Pet queryById(Integer petId);

	List<Pet> findBySpecies(String species);

	List<Pet> findBySexAndSpecies(String sex, String species);

}
