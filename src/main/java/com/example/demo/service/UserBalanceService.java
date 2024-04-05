package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojo.UserAccountBalance;
import com.example.demo.repo.UserBalanceRepo;

@Service
public class UserBalanceService {
	@Autowired
	  private UserBalanceRepo balanceRepo;
	public int getUserAccountBalance(int user_id) {
        UserAccountBalance accountBalance = balanceRepo.findByUserId(user_id);
        return accountBalance != null ? accountBalance.getBalance() : 0;
    }
}
