package com.mrbs.booking.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.mrbs.booking.bean.MeetingRequest;

import antlr.collections.List;

@Controller
public class UserController {

	
	@Autowired
	Environment environment;
	
	
	
	DateTimeFormatter datetimeformat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDateTime now = LocalDateTime.now();
	DateTimeFormatter timeformat = DateTimeFormatter.ofPattern("HH:mm:ss");
	LocalDateTime nowtime = LocalDateTime.now();

	// This method gets called from UserFunctionalities jsp and is used to request a
	// meeting room.
	// This gets executed and forwared to UserrestController and gets a table of
	// request of particular user and gives option of requesting meeting room.
	@RequestMapping(value = "meetingrequest", method = RequestMethod.POST)
	public ModelAndView meetingRequest(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		String variable = request.getParameter("operation");
		// System.out.println(variable);
		if (variable.equals("request")) {
			RestTemplate rest = new RestTemplate();
			String port = environment.getProperty("local.server.port");
			ResponseEntity<ArrayList<String>> responseEntity = rest.exchange(
					"http://localhost:"+port+"/userfunc/getmeetingroom", HttpMethod.GET, null,
					new ParameterizedTypeReference<ArrayList<String>>() {
					});

			ResponseEntity<ArrayList<String>> responseEntity1 = rest.exchange(
					"http://localhost:"+port+"/userfunc/getresource", HttpMethod.GET, null,
					new ParameterizedTypeReference<ArrayList<String>>() {
					});
			ModelAndView modelandview = new ModelAndView("MeetingRequest.jsp");

			modelandview.addObject("meetingrooms", responseEntity.getBody());
			modelandview.addObject("resources", responseEntity1.getBody());
			return modelandview;
		}
		// This method gets called from UserFunctionalities jsp and is used to cancel a
		// meeting room.
		// This gets executed and forwared to UserrestController and gets a table of
		// request of particular user and gives option of cancelling meeting room.
		if (variable.equals("cancel")) {
			String port = environment.getProperty("local.server.port");
			String user = (String) session.getAttribute("username");
			System.out.println(user);
			String url = "http://localhost:"+port+"/userfunc/check";
			HttpHeaders requestHeaders = new HttpHeaders();
			HttpEntity<String> requestEntity = new HttpEntity<>(user, requestHeaders);
			RestTemplate rest = new RestTemplate();
			ResponseEntity<ArrayList<MeetingRequest>> status = rest.exchange(url, HttpMethod.POST, requestEntity,
					new ParameterizedTypeReference<ArrayList<MeetingRequest>>() {
					});
			ModelAndView modelandview = new ModelAndView("Userrequests.jsp");
			modelandview.addObject("meetingrequests", status.getBody());
			return modelandview;
		}

		return null;

	}

	// This method gets called from RequestMeetingRoom jsp and is used to request a
	// meeting room.
	// This gets executed and forwared to UserrestController and gets a table of
	// request of particular user and gives option of requesting meeting room.
	@RequestMapping(value = "requestmeeting", method = RequestMethod.POST)
	public String requestmeeting(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String port = environment.getProperty("local.server.port");
		HttpSession session = request.getSession();
		MeetingRequest meetingrequest = new MeetingRequest();
		meetingrequest.setMrname(request.getParameter("Meetingroom_name"));
		meetingrequest.setStartdate(request.getParameter("startdate"));
		meetingrequest.setEnddate(request.getParameter("enddate"));
		meetingrequest.setStarttime(request.getParameter("starttime"));
		meetingrequest.setEndtime(request.getParameter("endtime"));
		meetingrequest.setResource(request.getParameter("Resource_name"));
		meetingrequest.setStatus("NEW");
		meetingrequest.setTimestamp(datetimeformat.format(now));
		meetingrequest.setTime(timeformat.format(nowtime));
		meetingrequest.setUser((String) session.getAttribute("username"));
		System.out.println(session.getAttribute("username"));

		String url = "http://localhost:"+port+"/userfunc/requestmeetingroom";

		RestTemplate resttemplate = new RestTemplate();
		String status = resttemplate.postForObject(url, meetingrequest, String.class);
		if (status.equals("REQUESTED")) {
			return "redirect:UserFunctionalities.jsp";
		} else
			return "Error.jsp";
	}

	// This method gets called from Userrequests jsp and is used to cancel a meeting
	// room.
	// This gets executed and forwared to UserrestController and gets a table of
	// request of particular user and gives option of cancelling meeting room.
	@RequestMapping(value = "cancelmeeting", method = RequestMethod.POST)
	public String cancelmeeting(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String port = environment.getProperty("local.server.port");
		MeetingRequest meetingrequest = new MeetingRequest();
		meetingrequest.setID(Integer.parseInt(request.getParameter("requestid")));
		String url = "http://localhost:"+port+"/userfunc/cancelrequest";
		RestTemplate resttemplate = new RestTemplate();
		String status = resttemplate.postForObject(url, meetingrequest, String.class);
		if (status.equals("CANCELLED"))
			return "redirect:UserFunctionalities.jsp";
		else
			return "redirect:Error.jsp";
	}

}
