package com.mrbs.booking.restcontroller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.mrbs.booking.bean.LoginBean;
import com.mrbs.booking.bean.MeetingRequest;
import com.mrbs.booking.bean.MeetingRoom;
import com.mrbs.booking.bean.Resource;
import com.mrbs.booking.repository.Fmrepo;
import com.mrbs.booking.repository.MeetingRequestRepo;
import com.mrbs.booking.repository.MeetingRoomRepo;
import com.mrbs.booking.repository.ResourceRepo;
import com.mrbs.booking.service.FacilityManagerDao;

@RestController
@RequestMapping("fmfunc")
public class FacilityManagerRestController {
	@Autowired
	FacilityManagerDao fmdao;

	@Autowired
	Fmrepo fmrepo;

	@Autowired
	MeetingRoomRepo meetingroomrepo;
	@Autowired
	ResourceRepo resourcerepo;
	@Autowired
	MeetingRequestRepo meetingrequestrepo;

	// This method gets data from FMController to add a user and these rest calls
	// are sent to service method.
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public String addUser(@RequestBody LoginBean log) {

		String status = fmdao.addUser(log);
		return status;

	}

	// This method gets data from FMController to add a meetingroom and these rest
	// calls are sent to service method
	@RequestMapping(value = "/addmeetingroom", method = RequestMethod.POST)
	public String addmeetingroom(@RequestBody MeetingRoom meetingroom) {
		String status = fmdao.addmeetingroom(meetingroom);
		return status;

	}

	// This method gets data from FMController to add a resource and these rest
	// calls are sent to service method
	@RequestMapping(value = "/addresource", method = RequestMethod.POST)
	public String addresource(@RequestBody Resource resource) {
		String status = fmdao.addresource(resource);
		return status;

	}

	// This method gets data from FMController to delete a user and these rest calls
	// are sent to service method
	@RequestMapping(value = "/deleteuser", method = RequestMethod.POST)
	public String deleteUser(@RequestBody LoginBean login) {
		String status = fmdao.deleteUser(login);
		return status;

	}

	// This method gets data from FMController to get request history table and
	// these rest calls are sent to service method
	@RequestMapping(value = "/getmonthrequests", method = RequestMethod.GET)
	public ArrayList<MeetingRequest> getRequests() {
		return fmdao.getMonthRequests();
	}

	// This method gets data from FMController to get meeting rquests and these rest
	// calls are sent to service method
	@RequestMapping(value = "/getrequests", method = RequestMethod.GET)
	public ArrayList<MeetingRequest> getrequests() {
		return fmdao.getRequests();
	}

	// This method gets data from FMController to accept a meeting request and these
	// rest calls are sent to service method
	@RequestMapping(value = "/acceptrequest", method = RequestMethod.POST)
	public String acceptrequest(@RequestBody MeetingRequest meetingrequest) {
		String status = fmdao.acceptRequest(meetingrequest);
		System.out.println(status);
		return status;

	}

	// This method gets data from FMController to reject a meeting request and these
	// rest calls are sent to service method
	@RequestMapping(value = "/rejectrequest", method = RequestMethod.POST)
	public String rejectrequest(@RequestBody MeetingRequest meetingrequest) {
		String status = fmdao.rejectRequest(meetingrequest);
		return status;
	}

	// This method gets data from FMController to get requests on a day and these
	// rest calls are sent to service method
	@RequestMapping(value = "/requestday", method = RequestMethod.POST)
	public String requestDay(@RequestBody MeetingRequest meetingrequest) {

		String status = fmdao.requestDay(meetingrequest);
		return status;
	}

	// This method gets data from FMController to get resources to dropdown menu and
	// these rest calls are sent to service method
	@RequestMapping(value = "/getresource", method = RequestMethod.GET)
	public ArrayList<String> getresource() {
		return fmdao.getResource();
	}

	// This method gets data from FMController to find no. of times a resource is
	// used and these rest calls are sent to service method
	@RequestMapping(value = "/resourceused", method = RequestMethod.POST)
	public String resourceused(@RequestBody MeetingRequest meetingrequest) {

		String status = fmdao.resourceused(meetingrequest);
		return status;
	}

	// This method gets data from FMController to get meetingrooms to dropdown menu
	// and these rest calls are sent to service method
	@RequestMapping(value = "/getmeetingroom", method = RequestMethod.GET)
	public ArrayList<String> getmeetingroom() {
		return fmdao.getMeetingroom();
	}

	// This method gets data from FMController to find no.of times a meeting room is
	// used and these rest calls are sent to service method
	@RequestMapping(value = "/meetingroomused", method = RequestMethod.POST)
	public String meetingroomused(@RequestBody MeetingRequest meetingrequest) {

		String status = fmdao.meetingroomused(meetingrequest);
		return status;
	}

}
