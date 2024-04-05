package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojo.Medicine;
import com.example.demo.pojo.OrderItemDTO;
import com.example.demo.pojo.PlaceOrder;
import com.example.demo.repo.OrderRepository;

@Service
public class OrderService {
	
	
	@Autowired
    private OrderRepository orderRepository;
	 @Autowired
	    private MedicineService medicineService; 

    public PlaceOrder placeNewOrder(List<OrderItemDTO> orderItems, double totalAmount) { 
		/* backup of cascade problem solved code
		 * if (order.getMedicines() != null) { List<Medicine> persistedMedicines = new
		 * ArrayList<>(); for (Medicine medicine : order.getMedicines()) {
		 * persistedMedicines.add(medicineService.insert(medicine)); // Save or update
		 * the medicines } order.setMedicines(persistedMedicines); // Set the managed
		 * medicines to the order }
		 */
    	 PlaceOrder order = new PlaceOrder();
         order.setTotalAmount(totalAmount);
         
         // Set medicines to the order
         orderItems.forEach(orderItem -> order.addMedicine(orderItem.getMedicine(), orderItem.getQuantity()));
         
         // Save order
         orderRepository.save(order);
    return orderRepository.save(order);
    }

    public PlaceOrder getOrderDetails(int order_Id) {
        return orderRepository.findById(order_Id).orElse(null);
    }

    public void cancelOrder(int order_Id) {
        orderRepository.deleteById(order_Id);
    }
    
    public List<PlaceOrder> findAll(){
		return orderRepository.findAll();
		
	}
    public void delete(int order_id) {
    	orderRepository.deleteById(order_id);
	}

}
