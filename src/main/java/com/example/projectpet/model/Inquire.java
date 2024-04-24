package com.example.projectpet.model;

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
@Table(name="inquires")
public class Inquire {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer inquireId;
	private String name;
	private String mobile;
	private String email;
	private String description;
	private boolean close;
}
