package com.example.projectpet.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InquireDAO extends JpaRepository<Inquire, Integer> {
	Inquire findByinquireId(Integer id);
}
