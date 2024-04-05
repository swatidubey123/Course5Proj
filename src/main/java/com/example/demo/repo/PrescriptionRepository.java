package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.pojo.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription,Integer>{

	/*
	 * String query1="select pres_id from place_order  where user_id=?1";
	 * 
	 * @Query(query1) public List<int> findByUserId(int pres_id);
	 */


}
