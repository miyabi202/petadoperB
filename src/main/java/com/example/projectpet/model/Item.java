package com.example.projectpet.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="items")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer itemId;
	private String itemName;
	private int price;
	private int quantity;
	private String description;
	private String hitShelvesDate;
	@Column(columnDefinition="Boolean")
	private boolean publish;
	private String imgPath;
	
	public Item(Integer itemId) {
		this.itemId = itemId;
	}
	
}
