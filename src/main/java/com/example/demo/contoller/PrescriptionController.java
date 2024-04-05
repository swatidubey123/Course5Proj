package com.example.demo.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Medicine;
import com.example.demo.pojo.Prescription;
import com.example.demo.service.PrescriptionService;

@RestController
//spring boot app is open to gt accessed for any external applciation 
//@CrossOrigin(origins = "localhost:4200")
@CrossOrigin(origins = "*")
	//@RequestMapping("/api/prescriptions")
public class PrescriptionController {
	@Autowired
    private PrescriptionService prescriptionService;

    @PostMapping("/createPrescription")
    public Prescription createPrescription(@RequestBody Prescription prescription) {
       
        return  prescriptionService.createPrescription(prescription);
    }

    @GetMapping("/details/{pres_id}")
    public Prescription getPrescriptionDetails(@PathVariable int pres_id) {
        Prescription prescription = prescriptionService.getPrescriptionDetails(pres_id);
        return prescription;
    }
	/*
	 * @GetMapping("/getAllPrescription/{user_id}") public List<Prescription>
	 * findAllPrescription(@PathVariable int user_id){ return
	 * prescriptionService.findByUserId(user_id); } // Other prescription
	 * functionalities...
	 */
}
