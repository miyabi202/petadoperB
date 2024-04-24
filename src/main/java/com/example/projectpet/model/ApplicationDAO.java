package com.example.projectpet.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ApplicationDAO extends JpaRepository<Application, Integer> {
	
    @Query(value = "select * from applications where alcId = ?1", nativeQuery = true)
    Application queryById(Integer alcId);
	
    @Query(value = "select * from applications where alcId = ?1", nativeQuery = true)
    List<Application> queryById2(Integer alcId);
	
}
