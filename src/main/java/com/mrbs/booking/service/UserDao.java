package com.mrbs.booking.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mrbs.booking.bean.MeetingRequest;
import com.mrbs.booking.repository.Fmrepo;
import com.mrbs.booking.repository.MeetingRequestRepo;
import com.mrbs.booking.repository.MeetingRoomRepo;
import com.mrbs.booking.repository.ResourceRepo;

@EnableAutoConfiguration
@Service
@Component
public class UserDao {

	@Autowired
	Fmrepo fmrepo;
	@Autowired
	MeetingRoomRepo meetingroomrepo;
	@Autowired
	ResourceRepo resourcerepo;
	@Autowired
	MeetingRequestRepo meetingrequestrepo;

	// This method saves meeting request to database.
	public String requestMeetingRoom(MeetingRequest meetingrequest) {

		System.out.println(meetingrequest);
		meetingrequestrepo.save(meetingrequest);

		return "REQUESTED";
	}

	// This method is used to get meeting rooms to drop down menu from database.
	public ArrayList<String> getMeetingRoom() {

		return meetingroomrepo.getMeetingRoom();
	}

	// This method is used to get resources to drop down menu from database.
	public ArrayList<String> getResource() {

		return resourcerepo.getResource();
	}

	// This method is used to display table of meeting request of a particular user
	// logging in
	public ArrayList<MeetingRequest> displayRequests(String user) {
		ArrayList<MeetingRequest> tranObj = (ArrayList<MeetingRequest>) meetingrequestrepo.getRequestsuser(user);
		return tranObj;

	}

	// This method is used to cancel requests made by particular user and requests
	// belonging to him.
	public String cancelRequest(MeetingRequest meetingrequest) {
		MeetingRequest meetingReq = meetingrequestrepo.findById(meetingrequest.getID()).get();
		meetingReq.setStatus("CANCELLED");
		meetingrequestrepo.save(meetingReq);
		return "CANCELLED";
	}

}
