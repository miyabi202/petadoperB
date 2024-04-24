package com.example.projectpet.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDAO extends JpaRepository<Order, Integer> {

	Order findByorderId(Integer id);

}
