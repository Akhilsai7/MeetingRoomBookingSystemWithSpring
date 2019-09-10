package com.mrbs.booking.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrbs.booking.bean.LoginBean;
import com.mrbs.booking.repository.LoginRepo;
@Service
public class LoginDao {
	@Autowired
	LoginRepo loginRepo;

	public  String check(LoginBean log) {
		
		String status=null;
		LoginBean list =loginRepo.findById(log.getUsername()).get();
		if (list.getUsername().equals(log.getUsername()) && list.getPassword().equals(log.getPassword())) {
				if (list.getRole().equals("FM")) {
					status = "FM";
				} else if (list.getRole().equals("USER")) {
					status = "USER";
				}
			}
		return status;
	
		
	}
	}