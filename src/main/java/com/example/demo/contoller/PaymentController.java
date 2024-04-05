package com.example.demo.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Payment;
import com.example.demo.service.PaymentService;

@RestController
//spring boot app is open to gt accessed for any external applciation 
//@CrossOrigin(origins = "localhost:4200")
@CrossOrigin(origins = "*")
	//@RequestMapping("/api/payments")
public class PaymentController {
	@Autowired
    private PaymentService paymentService;

    @PostMapping("/processPayment")
    public ResponseEntity<?> processPayment(@RequestBody Payment payment) {
        paymentService.processPayment(payment);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/details/{paymentId}")
    public Payment getPaymentDetails(@PathVariable int paymentId) {
        Payment payment = paymentService.getPaymentDetails(paymentId);
        return payment;
    }

}
