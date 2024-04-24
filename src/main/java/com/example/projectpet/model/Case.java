package com.example.projectpet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="cases")
public class Case {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer caseId;
	private String category;
    @OneToOne
    @JoinColumn(name = "alcId", referencedColumnName = "alcId")
	private Application alcId;
    @ManyToOne
    @JoinColumn(name = "petId", referencedColumnName = "petId")
	private Pet petId;
	private String applyDate;
	
}
