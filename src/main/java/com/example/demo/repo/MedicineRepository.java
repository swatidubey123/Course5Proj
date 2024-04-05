package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine,Integer> {
}
