package com.mrbs.booking.service;
import java.util.Optional;

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
		Optional<LoginBean> list =loginRepo.findById(log.getUsername());
		if (list.isPresent() && list.get().getUsername().equals(log.getUsername()) && list.get().getPassword().equals(log.getPassword())) {
				if (list.get().getRole().equals("FM")) {
					status = "FM";
				} else if (list.get().getRole().equals("USER")) {
					status = "USER";
				}
			}
		else
			status="Invalid";
		return status;
	
		
	}
	}