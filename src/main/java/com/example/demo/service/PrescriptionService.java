package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojo.Prescription;
import com.example.demo.repo.PrescriptionRepository;

@Service
public class PrescriptionService {
	 @Autowired
	    private PrescriptionRepository prescriptionRepository;

	    public Prescription createPrescription(Prescription prescription) {
	       return prescriptionRepository.save(prescription);
	    }

	    public Prescription getPrescriptionDetails(int prescriptionId) {
	        return prescriptionRepository.findById(prescriptionId).orElse(null);
	    }
	    
		/*
		 * public List<int> getPrescriptionsByUserId(int userId) { return
		 * prescriptionRepository.findByUserId(userId); }
		 */
}
