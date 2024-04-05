package com.example.demo.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaceOrder {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int order_id;
	 //	private int quantity;
	 	private double totalAmount;
	 
	 
	 @ManyToOne//(cascade = CascadeType.PERSIST)
	    @JoinColumn(name = "user_id")
	 	@JsonIgnore
	    private User user;
	 
		/*
		 * @OneToMany(mappedBy = "placeorder", cascade = CascadeType.ALL) List<Medicine>
		 * medicines;
		 */
	 @OneToMany(mappedBy = "placeOrder", cascade = CascadeType.ALL)
	    private List<OrderItem> orderItems = new ArrayList<>();
	 
	 @OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name="pres_id", referencedColumnName = "pres_id" )
	 private Prescription prescription;

	 public void addMedicine(Medicine medicine, int quantity) {
		    System.out.println("inside addmedicine method under placeorder pojo quantity is" + quantity);
		    OrderItem orderItem = new OrderItem(medicine, quantity);
		    orderItems.add(orderItem); // Assuming orderItems is initialized properly
		    if (medicine.getOrderItems() == null) {
		        medicine.setOrderItems(new ArrayList<>()); // Initialize orderItems list if null
		    }
		    medicine.getOrderItems().add(orderItem); // Add orderItem to the medicine's orderItems list
		}
	 
	 @Override
	 public String toString() {
	     return "PlaceOrder{" +
	             "orderId=" + order_id +
	             ", totalAmount=" + totalAmount +
	             ", user=" + (user != null ? user.getUser_id() : null) +
	             ", prescription=" + (prescription != null ? prescription.getPres_id() : null) +
	             // Include only relevant fields here, avoiding cyclic references
	             '}';
	 }
}
