package com.mrbs.booking.contoller;

import javax.servlet.http.HttpSession;

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

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView logincontroller() {
		ModelAndView mv = new ModelAndView("Login.jsp");
		LoginBean log = new LoginBean();
		mv.addObject(log);
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String logincontrol(LoginBean log, HttpSession session) {
		String url = "http://localhost:8080/valid/log";
		session.setAttribute("username", log.getUsername());
		RestTemplate resttemplate = new RestTemplate();
		String status = resttemplate.postForObject(url, log, String.class);
		System.out.println(status);
		if (status.equals("FM")) {
			return "redirect:FMFunctionalities.jsp";
		} else if (status.equals("USER")) {
			return "redirect:UserFunctionalities.jsp";
		} else {
			System.out.println("enter valid id or password");
		}
		return "redirect:Login.jsp";
	}
}
