package com.example.demo.pojo;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data

@AllArgsConstructor
@NoArgsConstructor
public class Medicine {
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int med_id;
	    
	    private String name;
	    private String brand;
	    private String dosage;
	    private double price;
	     
	    @OneToMany(mappedBy = "medicine")
	    @JsonIgnore
	    private List<OrderItem> orderItems;

	    @ManyToOne//(cascade = CascadeType.ALL)
	    @JoinColumn(name = "prescription_id")
	    @JsonIgnore
	    private Prescription prescription;
	   
	    
	    
	    
	    @ManyToOne//(cascade = CascadeType.ALL)
	    @JoinColumn(name = "order_id")
	    @JsonIgnore
	    private PlaceOrder placeorder;
	    
	    @Override
	    public int hashCode() {
	        return Objects.hash(med_id); // Assuming medicineId is a unique identifier
	    }
	    
	    @Override
	    public String toString() {
	        return "Medicine{" +
	                "med_id=" + med_id +
	                ", name='" + name + '\'' +
	                ", brand='" + brand + '\'' +
	                ", dosage='" + dosage + '\'' +
	                ", price=" + price +
	                // Include only relevant fields here
	                '}';
	    }
	    
		/*
		 * @OneToOne(cascade = CascadeType.ALL)
		 * 
		 * @JoinColumn(name="did", referencedColumnName = "driver_id" ) private Drivers
		 * driver;
		 */
}
