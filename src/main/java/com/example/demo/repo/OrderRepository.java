package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.pojo.PlaceOrder;

public interface OrderRepository extends JpaRepository<PlaceOrder,Integer> {

}

