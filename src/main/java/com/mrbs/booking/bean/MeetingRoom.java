package com.mrbs.booking.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class MeetingRoom {

	@Id
	private int meetingroomid;
	@NotNull
	private String meetingroomname;
	
	public int getMeetingroomid() {
		return meetingroomid;
	}
	public void setMeetingroomid(int meetingroomid) {
		this.meetingroomid = meetingroomid;
	}
	public String getMeetingroomname() {
		return meetingroomname;
	}
	public void setMeetingroomname(String meetingroomname) {
		this.meetingroomname = meetingroomname;
	}
	@Override
	public String toString() {
		return "MeetingRoom [meetingroomid=" + meetingroomid + ", meetingroomname=" + meetingroomname + "]";
	}
	
	
	
	
}
