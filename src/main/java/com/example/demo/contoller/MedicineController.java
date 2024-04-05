package com.example.demo.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Medicine;
import com.example.demo.pojo.User;
import com.example.demo.service.MedicineService;

@RestController
//spring boot app is open to gt accessed for any external applciation 
//@CrossOrigin(origins = "localhost:4200")
@CrossOrigin(origins = "*")
	//@RequestMapping("/api/medicines")
	public class MedicineController {

	  @Autowired
	  private MedicineService medicineService;

	  @PostMapping("/addMedicine")
	  public String addMedicine(@RequestBody Medicine medicine) {
		   medicineService.insert(medicine);
		   return "Medicine "+medicine.getName()+" has been saved successfully";
	  }
	  
	  

		@GetMapping("/getAllMeds")
		public List<Medicine> findAllMeds(){
			List<Medicine> medicines = medicineService.findAll();
		    System.out.println("All Medicines: " + medicines);
		    return medicines;
		}
		
		/*
		 * @GetMapping("/findbyemail/{email}") public List<User> finduser(@PathVariable
		 * String email) { return repo.findByEmail(email); }
		 */
		
		@DeleteMapping("/deleteMedbyid/{med_id}")
		public List<Medicine> delete(@PathVariable("med_id") int med_id) {
			medicineService.delete(med_id);
			return medicineService.findAll();
		}



	}


