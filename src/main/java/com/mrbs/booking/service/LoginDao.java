package com.mrbs.booking.service;

import java.util.ArrayList;

import com.mrbs.booking.bean.LoginBean;

public class LoginDao {

	public String check(LoginBean log, ArrayList<LoginBean> loginbean1) {
		String role = null;

		for (int i = 0; i < loginbean1.size(); i++) {
			if(log.getUsername().equals(loginbean1.get(i).getUsername())&&log.getPassword().equals(loginbean1.get(i).getPassword())) {
				if(loginbean1.get(i).getRole().equals("FM"))
				{
					role= "FM";
				}
				else if(loginbean1.get(i).getRole().equals("USER"))
				{
					role= "USER";
				}
			}
			else if(loginbean1.get(i).equals(null)&&loginbean1.get(i).getPassword().equals(null)) {
				 role="error";
			}
			
		}
		return role;
	}
	}