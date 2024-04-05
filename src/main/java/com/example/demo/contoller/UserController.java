package com.example.demo.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.LoginRequest;
import com.example.demo.pojo.User;
import com.example.demo.repo.UserRepo;

@RestController
//@RequestMapping("/api/users")
//spring boot app is open to gt accessed for any external applciation 
//@CrossOrigin(origins = "localhost:4200")
@CrossOrigin(origins = "*")

public class UserController {
	@Autowired
	private UserRepo repo;
	
	
	@PostMapping("/register")
	public String register(@RequestBody User user) {
		
		repo.save(user);
		return "Hey "+user.getName()+" your registration is successfully done ";

	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) 
	{
		System.out.println("inside loginUser password"+loginRequest.getPassword());
		System.out.println("inside loginUser username"+loginRequest.getUsername());
		User user = repo.findByNameAndPassword(loginRequest.getUsername(),loginRequest.getPassword());
		System.out.println("user usertype inside login user method  of user controller"+user.getUserType());
		
		 if (user != null) {
			 System.out.println("user usertype inside login user method  of user controller"+user.getUserType());
			 System.out.println("user phno inside login user method  of user controller"+user.getPhno());
	            return ResponseEntity.ok(user);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	}
	
	

	@GetMapping("/getAllusers")
	public List<User> findAllusers(){
		return repo.findAll();
	}
	
	
	@GetMapping("/findbyemail/{email}")
	public List<User> finduser(@PathVariable String email)
	{
		return repo.findByEmail(email);
	}
	
	@DeleteMapping("/cancel/{user_id}")
	public List<User> cancelregistartion(@PathVariable int user_id){
		repo.deleteById(user_id);
		return repo.findAll();
	}

}
