package com.example.demo.contoller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Medicine;

@RestController
//@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminController {
	/*
	 * @PostMapping("/addAdminMedicine") public Medicine addMedicine(@RequestBody
	 * Medicine medicine) { // Logic to add medicine (Admin functionality) return
	 * ResponseEntity.ok().build(); }
	 * 
	 * @PostMapping("/updateAdminMedicine") public Medicine
	 * updateMedicine(@RequestBody Medicine medicine) { // Logic to update medicine
	 * (Admin functionality) return ResponseEntity.ok().build(); }
	 * 
	 * @DeleteMapping("/deleteMedicine/{medicineId}") public ResponseEntity<?>
	 * deleteMedicine(@PathVariable Long medicineId) { // Logic to delete medicine
	 * (Admin functionality) return ResponseEntity.ok().build(); }
	 * 
	 */
}
