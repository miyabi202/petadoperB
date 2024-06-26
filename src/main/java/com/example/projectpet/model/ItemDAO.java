package com.example.projectpet.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDAO extends JpaRepository<Item, Integer> {

	Item queryByitemId(Integer itemId);

}
