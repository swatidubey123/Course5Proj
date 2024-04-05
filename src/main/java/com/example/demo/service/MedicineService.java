package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojo.Medicine;
import com.example.demo.repo.MedicineRepository;

@Service
public class MedicineService {
	
	 @Autowired
	  private MedicineRepository medicineRepository;

	 public Medicine insert(Medicine medicine) {
			return medicineRepository.save(medicine);
		}

	public List<Medicine> insertall(List<Medicine> medicines){
		return medicineRepository.saveAll(medicines);
	}
	
	public List<Medicine> findAll(){
		return medicineRepository.findAll();
		
	}
	public void delete(int id) {
		medicineRepository.deleteById(id);
	}
	


}
