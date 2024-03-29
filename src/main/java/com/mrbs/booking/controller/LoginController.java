package com.mrbs.booking.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.mrbs.booking.bean.LoginBean;

@Controller
@RequestMapping("/control")
@SessionAttributes("login")
public class LoginController {
	@Autowired
	Environment environment;
	
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView logincontroller() {
		ModelAndView modelandview = new ModelAndView("Login.jsp");
		LoginBean log = new LoginBean();
		modelandview.addObject(log);
		return modelandview;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String logincontrol(LoginBean log, HttpSession session) {
		String port = environment.getProperty("local.server.port");
		String url = "http://localhost:"+port+"/valid/log";
		session.setAttribute("username", log.getUsername());
		RestTemplate resttemplate = new RestTemplate();
		String status = resttemplate.postForObject(url, log, String.class);
		if (status.equals("FM")) {
			return "redirect:FMFunctionalities.jsp";
		} else if (status.equals("USER")) {
			return "redirect:UserFunctionalities.jsp";
		} 
		else
			return "redirect:Error.jsp";
	}
}
