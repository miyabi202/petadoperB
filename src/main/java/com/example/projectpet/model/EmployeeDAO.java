package com.example.projectpet.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDAO extends JpaRepository<Employee, Integer> {

	Employee findByempId(Integer id);

	Employee findByUsernameAndPassword(String name, String password);

}
