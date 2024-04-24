package com.example.projectpet.model;

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
@Table(name="applications")
public class Application {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer alcId;
	private String firstName;
	private String lastName;
	private String address;
	private String mobile;
	private String sex;
	private int age;
	@Column(columnDefinition="Boolean")
	private boolean property;
	private String occupation;
	private String email;
	private String keepAddress;
	private String reason;
	public Application(Integer alcId) {
		super();
		this.alcId = alcId;
	}

	
}
