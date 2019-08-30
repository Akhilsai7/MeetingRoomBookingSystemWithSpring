package com.mrbs.booking.restcontroller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mrbs.booking.bean.LoginBean;
import com.mrbs.booking.repository.LoginRepo;
import com.mrbs.booking.service.LoginDao;

@RestController
@RequestMapping("valid")
public class LoginRestController {

	@Autowired
	LoginRepo loginrep;

	@RequestMapping(value = "/log", method = RequestMethod.POST)
	public String insert(@RequestBody LoginBean log) {
		System.out.println(log + "&^&&*&");
		ArrayList<LoginBean> loginbean1 = (ArrayList<LoginBean>) loginrep.findAll();
		String status = new LoginDao().check(log, loginbean1);
		System.out.println(status);
		return status;

	}
}
