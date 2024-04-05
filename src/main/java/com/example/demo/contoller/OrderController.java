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

import com.example.demo.pojo.OrderItemDTO;
import com.example.demo.pojo.PlaceOrder;
import com.example.demo.service.OrderService;

@RestController
//spring boot app is open to gt accessed for any external applciation 
//@CrossOrigin(origins = "localhost:4200")
@CrossOrigin(origins = "*")
	//@RequestMapping("/api/orders")
public class OrderController {
	
	@Autowired
	  private OrderService orderservice;

	  @PostMapping("/placeOrder")
	  public ResponseEntity<String> placeOrder(@RequestBody List<OrderItemDTO> orderItems) {
		  double totalAmount = orderItems.stream()
	                .mapToDouble(item -> item.getQuantity() * item.getMedicine().getPrice())
	                .sum();
			 
		  orderservice.placeNewOrder(orderItems, totalAmount);
	        
	        return ResponseEntity.ok("Order placed successfully. Total amount: " + totalAmount);
	  }
	  
	  @GetMapping("/orderDetails/{order_id}")
	    public PlaceOrder getOrderDetails(@PathVariable int order_Id) {
		  PlaceOrder order = orderservice.getOrderDetails(order_Id);
	        return order;
	    }
	  
	  
		
		@DeleteMapping("/deletebyid/{order_id}")
		public List<PlaceOrder> delete(@PathVariable("order_id") int order_id) {
			orderservice.delete(order_id);
			return orderservice.findAll();
		}


		
		/*
		 * @GetMapping("/findbyemail/{email}") public List<User> finduser(@PathVariable
		 * String email) { return repo.findByEmail(email); }
		 */



}
