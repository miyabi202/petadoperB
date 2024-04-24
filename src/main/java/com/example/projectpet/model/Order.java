package com.example.projectpet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
    @ManyToOne
    @JoinColumn(name = "memberId", referencedColumnName = "memberId")
	private Member memberId;
	private String createDate;
	private String comment;
	private String status;
	private String shippingDate;
	
	public Order(Integer orderId) {
		this.orderId = orderId;
	}

}
