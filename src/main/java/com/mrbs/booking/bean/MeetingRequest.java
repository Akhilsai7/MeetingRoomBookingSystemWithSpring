package com.mrbs.booking.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class MeetingRequest {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	@NotNull
	private String startdate;
	@NotNull
	private String enddate;
	@NotNull
	private String starttime;
	@NotNull
	private String endtime;
	@NotNull
	private String user;
	@NotNull
	private String mrname;
	
	private String resource;
	@NotNull
	private String status;

	private String timestamp;
	
	private String time;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getMrname() {
		return mrname;
	}

	public void setMrname(String mrname) {
		this.mrname = mrname;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "MeetingRequest [ID=" + ID + ", startdate=" + startdate + ", enddate=" + enddate + ", starttime="
				+ starttime + ", endtime=" + endtime + ", user=" + user + ", mrname=" + mrname + ", resource="
				+ resource + ", status=" + status + ", timestamp=" + timestamp + ", time=" + time + "]";
	}
	
	
}
