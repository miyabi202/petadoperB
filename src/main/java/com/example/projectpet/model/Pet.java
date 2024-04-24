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
@Table(name="pets")
public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer petId;
	private String name;
	private String sex;
	private int age;
	private int weight;
	private String species;
	private String kind;
	@Column(columnDefinition="Boolean")
	private boolean sterilize;
	private String address;
	private String source;
	private String profile;
	private String status;
	@Column(columnDefinition="Boolean")
	private boolean publish;
	private String fileDate;
	private String imgPath;
	
	public Pet(Integer petId) {
		this.petId = petId;
	}

	
}
