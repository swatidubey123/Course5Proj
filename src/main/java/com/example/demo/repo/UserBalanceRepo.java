package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.pojo.UserAccountBalance;

public interface UserBalanceRepo extends JpaRepository<UserAccountBalance, Integer>{
	  @Query("SELECT ub FROM UserAccountBalance ub WHERE ub.user.user_id = ?1")
	    UserAccountBalance findByUserId(int userId);
}
