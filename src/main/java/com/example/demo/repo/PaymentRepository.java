package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.Payment;
import com.example.demo.pojo.Prescription;

public interface PaymentRepository extends JpaRepository<Payment,Integer>{

}
