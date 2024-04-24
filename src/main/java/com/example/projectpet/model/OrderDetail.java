package com.example.projectpet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="orderDetails")
@IdClass(ODId.class)
public class OrderDetail {
	@Id
	private Order orderId;
	@Id
	private Item itemId;
	private int price;
	private int quantity;
	private int subtotal;

}
