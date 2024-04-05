package com.example.demo.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prescription {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pres_id;
    
    private String name;
    private String symptoms; 
       
    
	/*commented to change cascade type
	 * @OneToMany(mappedBy = "prescription", cascade = CascadeType.ALL)
	 * List<Medicine> medicines;
	 */
   //new changed code 
    @OneToMany(mappedBy = "prescription", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Medicine> medicines;



	/*
	 * @ManyToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "user_id") private PlaceOrder ordermed;
	 */
   
    @Override
    public String toString() {
        return "Prescription{" +
                "pres_id=" + pres_id +
                ", name='" + name + '\'' +
                ", symptoms='" + symptoms + '\'' +
                // Include only relevant fields here
                '}';
    }
}
