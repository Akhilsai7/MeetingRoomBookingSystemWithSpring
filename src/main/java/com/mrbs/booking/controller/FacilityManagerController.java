package com.mrbs.booking.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.mrbs.booking.bean.LoginBean;
import com.mrbs.booking.bean.MeetingRequest;
import com.mrbs.booking.bean.MeetingRoom;
import com.mrbs.booking.bean.Resource;

@Controller
public class FacilityManagerController {
	@Autowired
	Environment environment;
	
	


	// This Method is called from the FMFunctionalities jsp page and this method is
	// used to add a user to database.
	// After this method gets executed it is forwarded to the
	// FacilityManagerRestController with path as adduser where rest calls are made
	// and returned from the same.
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String adduser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String port = environment.getProperty("local.server.port");
		LoginBean loginbean = new LoginBean();

		loginbean.setUsername(request.getParameter("username"));
		loginbean.setPassword(request.getParameter("password"));
		loginbean.setRole("USER");

		System.out.println("loginbean = " + loginbean);

		String url = "http://localhost:"+port+"/fmfunc/adduser";

		RestTemplate resttemplate = new RestTemplate();
		String status = resttemplate.postForObject(url, loginbean, String.class);

		if (status.equals("ADDED"))
			return "redirect:FMFunctionalities.jsp";
		else
			return "redirect:Error.jsp";

	}

	// This Method is called from the FMFunctionalities jsp page and this method is
	// used to add a Meetingroom to database.
	// After this method gets executed it is forwarded to the
	// FacilityManagerRestController with path /addmeetingroom where rest calls are
	// made and returned from the same.
	@RequestMapping(value = "addmeetingroom", method = RequestMethod.POST)
	public String addmeetingroom(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String port = environment.getProperty("local.server.port");
		MeetingRoom meetingroom = new MeetingRoom();
		meetingroom.setMeetingroomid(Integer.parseInt(request.getParameter("meetingroomid")));
		meetingroom.setMeetingroomname(request.getParameter("meetingroomname"));
		String url = "http://localhost:"+port+"/fmfunc/addmeetingroom";

		RestTemplate resttemplate = new RestTemplate();
		String status = resttemplate.postForObject(url, meetingroom, String.class);
		if (status.equals("ADDED"))
			return "redirect:FMFunctionalities.jsp";
		else
			return "redirect:Error.jsp";
	}

	// This Method is called from the FMFunctionalities jsp page and this method is
	// used to add a Resource to database.
	// After this method gets executed it is forwarded to the
	// FacilityManagerRestController with path /addresource where rest calls are
	// made and returned from the same.
	@RequestMapping(value = "addresource", method = RequestMethod.POST)
	public String addResource(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String port = environment.getProperty("local.server.port");
		Resource resource = new Resource();
		resource.setResourceid(Integer.parseInt(request.getParameter("resourceid")));
		resource.setResourcename(request.getParameter("resourcename"));
		String url = "http://localhost:"+port+"/fmfunc/addresource";

		RestTemplate resttemplate = new RestTemplate();
		String status = resttemplate.postForObject(url, resource, String.class);
		if (status.equals("ADDED"))
			return "redirect:FMFunctionalities.jsp";
		else
			return "redirect:Error.jsp";
	}

	// This Method is called from the FMFunctionalities jsp page and this method is
	// used to Delete a user from database.
	// After this method gets executed it is forwarded to the
	// FacilityManagerRestController with path deleteuser where rest calls are made
	// and returned from the same.
	@RequestMapping(value = "deleteuser", method = RequestMethod.POST)
	public String deleteUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String port = environment.getProperty("local.server.port");
		LoginBean login = new LoginBean();
		login.setUsername(request.getParameter("username"));
		String url = "http://localhost:"+port+"/fmfunc/deleteuser";
		RestTemplate resttemplate = new RestTemplate();
		String status = resttemplate.postForObject(url, login, String.class);
		if (status.equals("DELETED"))
			return "redirect:FMFunctionalities.jsp";
		else
			return "redirect:Error.jsp";

	}

	// This Method is called from the FMFunctionalities jsp page and this method is
	// used to get Request history from database.
	// After this method gets executed it is forwarded to the
	// FacilityManagerRestController with path /monthrequests where rest calls are
	// made and returned from the same.
	@RequestMapping(value = "/viewmonthrequests", method = RequestMethod.GET)
	public ModelAndView viewMonthRequests(HttpServletRequest request, HttpServletResponse response) {
		String port = environment.getProperty("local.server.port");
		RestTemplate rest = new RestTemplate();
		ModelAndView modelandview = new ModelAndView();
		ResponseEntity<List<MeetingRequest>> responseEntity = rest.exchange(
				"http://localhost:"+port+"/fmfunc/getmonthrequests", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<MeetingRequest>>() {
				});
		modelandview.addObject("list", responseEntity.getBody());
		request.setAttribute("list", responseEntity.getBody());
		modelandview.setViewName("MonthBookings.jsp");
		return modelandview;
	}

	// This Method is called from the FMFunctionalities jsp page and this method is
	// used to get details of new meeting requests from database.
	// After this method gets executed it is forwarded to the
	// FacilityManagerRestController with path /getrequests where rest calls are
	// made and returned from the same.
	@RequestMapping(value = "/AcceptReject", method = RequestMethod.GET)
	public ModelAndView viewRequests(HttpServletRequest request, HttpServletResponse response) {
		String port = environment.getProperty("local.server.port");
		RestTemplate rest = new RestTemplate();
		ModelAndView modelandview = new ModelAndView();
		ResponseEntity<List<MeetingRequest>> responseEntity = rest.exchange("http://localhost:"+port+"/fmfunc/getrequests",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<MeetingRequest>>() {
				});
		modelandview.addObject("list", responseEntity.getBody());
		request.setAttribute("list", responseEntity.getBody());
		modelandview.setViewName("RequestTable.jsp");
		return modelandview;
	}

	// This Method is called from the FMFunctionalities jsp page and this method is
	// used to accept or reject a request.
	// After this method gets executed it is forwarded to the
	// FacilityManagerRestController with path /acceptrequest and /rejectrequest
	// where rest calls are made and returned from the same.
	@RequestMapping(value = "/acceptorreject", method = RequestMethod.POST)
	public String acceptorReject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String port = environment.getProperty("local.server.port");
		String variable = request.getParameter("operation");
		if (variable.equals("approverequest")) {
			MeetingRequest meetingrequest = new MeetingRequest();
			meetingrequest.setID(Integer.parseInt(request.getParameter("requestid")));
			String url = "http://localhost:"+port+"/fmfunc/acceptrequest";
			RestTemplate resttemplate = new RestTemplate();
			String status = resttemplate.postForObject(url, meetingrequest, String.class);
			if (status.equals("ACCEPTED"))
				return "redirect:FMFunctionalities.jsp";
			else
				return "redirect:Error.jsp";
		}
		if (variable.equals("rejectrequest")) {
			MeetingRequest meetingrequest = new MeetingRequest();
			meetingrequest.setID(Integer.parseInt(request.getParameter("requestid")));
			String url = "http://localhost:"+port+"/fmfunc/rejectrequest";
			RestTemplate resttemplate = new RestTemplate();
			String status = resttemplate.postForObject(url, meetingrequest, String.class);
			if (status.equals("REJECTED"))
				return "redirect:FMFunctionalities.jsp";
			else
				return "redirect:Error.jsp";
		}
		return "redirect:Error.jsp";
	}

	// This Method is called from the FMFunctionalities jsp page and this method is
	// used to get meeting requests of a particular day from database.
	// After this method gets executed it is forwarded to the
	// FacilityManagerRestController with path /requestday where rest calls are made
	// and returned from the same.
	@RequestMapping(value = "/requestsaday", method = RequestMethod.POST)
	public String requestDay(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String port = environment.getProperty("local.server.port");
		MeetingRequest meetingrequest = new MeetingRequest();
		meetingrequest.setTimestamp(request.getParameter("date"));
		String url = "http://localhost:"+port+"/fmfunc/requestday";
		RestTemplate resttemplate = new RestTemplate();
		String status = resttemplate.postForObject(url, meetingrequest, String.class);
		if (status != null) {
			request.setAttribute("status", status);
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("RequestsOnADay.jsp");
			requestdispatcher.forward(request, response);
			return status;
		} else
			return "redirect:Error.jsp";

	}

	// This Method is called from the FMFunctionalities jsp page and this method is
	// used to get resource list to dropdown.
	// After this method gets executed it is forwarded to the
	// FacilityManagerRestController with path /getresource where rest calls are
	// made and returned from the same.
	@RequestMapping(value = "/resourceused", method = RequestMethod.GET)
	public ModelAndView resources(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		String port = environment.getProperty("local.server.port");
		RestTemplate rest = new RestTemplate();

		ResponseEntity<ArrayList<String>> responseEntity1 = rest.exchange("http://localhost:"+port+"/fmfunc/getresource",
				HttpMethod.GET, null, new ParameterizedTypeReference<ArrayList<String>>() {
				});
		ModelAndView modelandview = new ModelAndView("ResourceUsed.jsp");

		modelandview.addObject("resources", responseEntity1.getBody());
		return modelandview;
	}

	// This Method is called from the FMFunctionalities jsp page and this method is
	// used to find number of times a resource is used.
	// After this method gets executed it is forwarded to the
	// FacilityManagerRestController with path /resourceused where rest calls are
	// made and returned from the same.
	@RequestMapping(value = "/resourcetimes", method = RequestMethod.POST)
	public String resourceused(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String port = environment.getProperty("local.server.port");
		MeetingRequest meetingrequest = new MeetingRequest();
		meetingrequest.setResource(request.getParameter("resourcename"));
		String url = "http://localhost:"+port+"/fmfunc/resourceused";
		RestTemplate resttemplate = new RestTemplate();
		String status = resttemplate.postForObject(url, meetingrequest, String.class);
		if (status != null) {
			request.setAttribute("status", status);
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("ResourceUsedtimes.jsp");
			requestdispatcher.forward(request, response);
		}
		return status;
	}

	// This Method is called from the FMFunctionalities jsp page and this method is
	// used to get meetingrooms list.
	// After this method gets executed it is forwarded to the
	// FacilityManagerRestController with path /getmeetingroom where rest calls are
	// made and returned from the same.
	@RequestMapping(value = "/meetingroomused", method = RequestMethod.GET)
	public ModelAndView meetingroomuse(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		String port = environment.getProperty("local.server.port");
		RestTemplate rest = new RestTemplate();

		ResponseEntity<ArrayList<String>> responseEntity1 = rest.exchange("http://localhost:"+port+"/fmfunc/getmeetingroom",
				HttpMethod.GET, null, new ParameterizedTypeReference<ArrayList<String>>() {
				});
		ModelAndView modelandview = new ModelAndView("MeetingRoom.jsp");

		modelandview.addObject("meetingrooms", responseEntity1.getBody());
		return modelandview;
	}

	// This Method is called from the FMFunctionalities jsp page and this method is
	// used to find number of times a meeting room is used.
	// After this method gets executed it is forwarded to the
	// FacilityManagerRestController with path /meetingroomused where rest calls are
	// made and returned from the same.
	@RequestMapping(value = "/meetingtimes", method = RequestMethod.POST)
	public String meetingroomused(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String port = environment.getProperty("local.server.port");
		MeetingRequest meetingrequest = new MeetingRequest();
		meetingrequest.setMrname(request.getParameter("Meetingroomname"));
		String url = "http://localhost:"+port+"/fmfunc/meetingroomused";
		RestTemplate resttemplate = new RestTemplate();
		String status = resttemplate.postForObject(url, meetingrequest, String.class);
		if (status != null) {
			request.setAttribute("status", status);
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("MeetingRoomUsedtimes.jsp");
			requestdispatcher.forward(request, response);
		}
		return status;
	}

}
