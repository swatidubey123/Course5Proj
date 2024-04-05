package com.example.demo.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data

@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderItemid;

	  @ManyToOne
	    private PlaceOrder placeOrder;
	  
	@ManyToOne
	private Medicine medicine;

	private int quantity;

	public OrderItem(Medicine medicine, int quantity) {
		// this.placeOrder = placeOrder;
		this.medicine = medicine;
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
	    return "OrderItem{" +
	            "orderItemId=" + orderItemid +
	            ", medicine=" + (medicine != null ? medicine.getMed_id() : null) +
	            ", quantity=" + quantity +
	            // Include only relevant fields here, avoiding cyclic references
	            '}';
	}
}
