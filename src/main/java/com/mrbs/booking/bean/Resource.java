package com.mrbs.booking.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class Resource {
	
	@Id
	private int resourceid;
	@NotNull
	private String resourcename;
	public int getResourceid() {
		return resourceid;
	}
	public void setResourceid(int resourceid) {
		this.resourceid = resourceid;
	}
	public String getResourcename() {
		return resourcename;
	}
	public void setResourcename(String resourcename) {
		this.resourcename = resourcename;
	}
	@Override
	public String toString() {
		return "Resource [resourceid=" + resourceid + ", resourcename=" + resourcename + "]";
	}
	
	
}
