package com.mrbs.booking.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mrbs.booking.bean.LoginBean;
import com.mrbs.booking.bean.MeetingRequest;
import com.mrbs.booking.bean.MeetingRoom;
import com.mrbs.booking.bean.Resource;
import com.mrbs.booking.repository.Fmrepo;
import com.mrbs.booking.repository.MeetingRequestRepo;
import com.mrbs.booking.repository.MeetingRoomRepo;
import com.mrbs.booking.repository.ResourceRepo;

@EnableAutoConfiguration
@Service
@Component
public class FacilityManagerDao {

	@Autowired
	Fmrepo fmrepo;
	@Autowired
	MeetingRoomRepo meetingroomrepo;
	@Autowired
	ResourceRepo resourcerepo;
	@Autowired
	MeetingRequestRepo meetingrequestrepo;

	// This method saves data of add user to database.
	public String addUser(LoginBean log) {

		fmrepo.save(log);
		return "ADDED";
	}

	// This method saves data of new meeting room to database.
	public String addmeetingroom(MeetingRoom meetingroom) {
		meetingroomrepo.save(meetingroom);
		return "ADDED";
	}

	// This method saves data of new resource to database.
	public String addresource(Resource resource) {
		if (resource != null) {
			
			resourcerepo.save(resource);
			return "ADDED";
		}
		return "NOTADDED";
	}

	// This method deletes data of user deletion to database.
	public String deleteUser(LoginBean login) {

		fmrepo.deleteById(login.getUsername());
		return "DELETED";
	}

	// This method gets data of meeting request history from database.
	public ArrayList<MeetingRequest> getMonthRequests() {

		return (ArrayList<MeetingRequest>) meetingrequestrepo.findAll();
	}

	// This method gets data of meeting request history with status as "NEW" from
	// database.
	public ArrayList<MeetingRequest> getRequests() {
		return (ArrayList<MeetingRequest>) meetingrequestrepo.getNewRequests();
	}

	// This method accepts meeting requests and updates in database.
	public String acceptRequest(MeetingRequest meetingrequest) {

		MeetingRequest meetingReq = meetingrequestrepo.findById(meetingrequest.getID()).get();
		meetingReq.setStatus("ACCEPTED");
		meetingrequestrepo.save(meetingReq);
		return "ACCEPTED";
	}

	// This method rejects meeting requests and updates in database.
	public String rejectRequest(MeetingRequest meetingrequest) {

		MeetingRequest meetingReq = meetingrequestrepo.findById(meetingrequest.getID()).get();
		meetingReq.setStatus("REJECTED");
		meetingrequestrepo.save(meetingReq);
		return "REJECTED";
	}

	// This method gets requests in a day and updates in database.
	public String requestDay(MeetingRequest meetingrequest) {
		String dayString = meetingrequest.getTimestamp();
		return meetingrequestrepo.getdayrequest(dayString);
	}

	// This method gets resource list from database.
	public ArrayList<String> getResource() {

		return resourcerepo.getResource();
	}

	// This method is used to find resource used times from database.
	public String resourceused(MeetingRequest meetingrequest) {
		String resources = meetingrequest.getResource();
		System.out.println(resources);
		return meetingrequestrepo.getresourceused(resources);
	}

	// This method gets meeting room list from database.
	public ArrayList<String> getMeetingroom() {
		return meetingroomrepo.getMeetingRoom();
	}

	// This method is used to find meeting room used times from database.
	public String meetingroomused(MeetingRequest meetingrequest) {
		String room = meetingrequest.getMrname();
		System.out.println(room);
		return meetingrequestrepo.getmeetingroomused(room);

	}

}
