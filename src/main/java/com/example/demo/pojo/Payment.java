package com.example.demo.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pay_id;

    private double amount;
    private String paymentMethod;

    // Other fields and getters/setters

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="order_id", referencedColumnName = "order_id" )

    private PlaceOrder ordermed;

    // Getters/setters
}
