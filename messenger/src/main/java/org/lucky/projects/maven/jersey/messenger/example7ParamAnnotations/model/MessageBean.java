package org.lucky.projects.maven.jersey.messenger.example7ParamAnnotations.model;

import javax.ws.rs.QueryParam;

public class MessageBean {

	private @QueryParam("year") int year;
	private @QueryParam("start") int start;
	private @QueryParam("size") int pageSize;
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
