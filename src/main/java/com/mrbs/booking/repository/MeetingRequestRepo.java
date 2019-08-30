package com.mrbs.booking.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mrbs.booking.bean.MeetingRequest;

@Repository
public interface MeetingRequestRepo extends JpaRepository<MeetingRequest, Integer>{

	@Query("select s from MeetingRequest s where s.status='NEW'")
	public ArrayList<MeetingRequest> getNewRequests();

	@Query("select count(s) from MeetingRequest s where s.timestamp=?1")
	public String getdayrequest( String timestamp);

	
	@Query("select s from MeetingRequest s where s.user=?1")
	public ArrayList<MeetingRequest> getRequestsuser(String user);
	
	@Query("select count(s) from MeetingRequest s where s.resource=?1")
	public String getresourceused(String resources);
	
	@Query("select count(s) from MeetingRequest s where s.mrname=?1")
	public String getmeetingroomused(String room);

	

	

	
	
	

}
