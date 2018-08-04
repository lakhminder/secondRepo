package com.thoughtworks.assignment1.code.model;


public class Track {
	

	private String name;
	private Session morningSession;
	private Session afternoonSession;
	private Session lunchSession;
	private Session networkingEvent;
	
	public Track(String name) {
		super();
		this.name = name;
	}
	
	public Session getMorningSession() {
		return morningSession;
	}
	public void setMorningSession(Session morningSession) {
		this.morningSession = morningSession;
	}
	public Session getAfternoonSession() {
		return afternoonSession;
	}
	public void setAfternoonSession(Session afternoonSession) {
		this.afternoonSession = afternoonSession;
	}
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(name);
		sb.append(morningSession);
		sb.append(lunchSession);
		sb.append(afternoonSession);
		sb.append(networkingEvent);
		
		return sb.toString();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Session getLunchSession() {
		return lunchSession;
	}
	public void setLunchSession(Session lunchSession) {
		this.lunchSession = lunchSession;
	}

	public Session getNetworkingEvent() {
		return networkingEvent;
	}

	public void setNetworkingEvent(Session networkingEvent) {
		this.networkingEvent = networkingEvent;
	}
	
	

}
