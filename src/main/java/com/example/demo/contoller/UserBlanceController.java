package com.example.demo.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Medicine;
import com.example.demo.pojo.User;
import com.example.demo.repo.UserBalanceRepo;
import com.example.demo.repo.UserRepo;
import com.example.demo.service.MedicineService;
import com.example.demo.service.UserBalanceService;

@RestController
//@RequestMapping("/api/users")
//spring boot app is open to gt accessed for any external applciation 
//@CrossOrigin(origins = "localhost:4200")


@CrossOrigin(origins = "*")
public class UserBlanceController {
	 @Autowired
	  private UserBalanceService balanceService;
	 
	
	 @PostMapping("/checkBalance")
	    public ResponseEntity<?> checkUserBalance(@RequestBody User user) {
		 System.out.println("inside checkUserBalance the userId is"+user.getUser_id());
	        int balance = balanceService.getUserAccountBalance(user.getUser_id());
	        System.out.println("inside checkUserBalance the balance is "+balance);
	        return ResponseEntity.ok(balance);
	    }
}
