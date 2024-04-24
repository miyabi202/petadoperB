package com.example.projectpet.model;

import java.io.Serializable;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ODId implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1953137913811862012L;

	@ManyToOne
    @JoinColumn(name = "orderId", referencedColumnName = "orderId")
	private Order orderId;
    
    @ManyToOne
    @JoinColumn(name = "itemId", referencedColumnName = "itemId")
	private Item itemId;
}
