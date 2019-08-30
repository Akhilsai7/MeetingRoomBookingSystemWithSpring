package com.mrbs.booking.restcontroller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mrbs.booking.bean.LoginBean;
import com.mrbs.booking.bean.MeetingRequest;
import com.mrbs.booking.repository.MeetingRequestRepo;
import com.mrbs.booking.service.UserDao;

@RestController
@RequestMapping("userfunc")
public class UserRestController {
	@Autowired
	UserDao userdao;

	@Autowired
	MeetingRequestRepo meetingrequestrepo;

	// This method is used to get meeting rooms to drop down menu and is forwarded
	// to userdao.
	@RequestMapping(value = "/getmeetingroom", method = RequestMethod.GET)
	public ArrayList<String> getmeetingroom() {
		System.out.println(userdao.getMeetingRoom());
		return userdao.getMeetingRoom();
	}

	// This method is used to get resources to drop down menu and is forwarded to
	// userdao.
	@RequestMapping(value = "/getresource", method = RequestMethod.GET)
	public ArrayList<String> getresource() {
		return userdao.getResource();
	}

	// This method is used to request meeting room and is forwarded to userdao.
	@RequestMapping(value = "/requestmeetingroom", method = RequestMethod.POST)
	public String requestmeetingRoom(@RequestBody MeetingRequest meetingrequest) {

		String status = userdao.requestMeetingRoom(meetingrequest);
		return status;
	}

	// This method is used to get meeting request table and is forwarded to userdao.
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public ArrayList<MeetingRequest> findTransaction(@RequestBody String user) {
		ArrayList<MeetingRequest> tranObj = userdao.displayRequests(user);
		return tranObj;
	}

	// This method is used to cancel meeting requests and is forwarded to userdao.
	@RequestMapping(value = "/cancelrequest", method = RequestMethod.POST)
	public String acceptrequest(@RequestBody MeetingRequest meetingrequest) {
		String status = userdao.cancelRequest(meetingrequest);
		return status;

	}

}
