package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojo.Payment;
import com.example.demo.repo.PaymentRepository;

@Service
public class PaymentService {
	
	 @Autowired
	    private PaymentRepository paymentRepository;

	    public Payment processPayment(Payment payment) {
	        return paymentRepository.save(payment);
	    }

	    public Payment getPaymentDetails(int pay_id) {
	        return paymentRepository.findById(pay_id).orElse(null);
	    }

}
