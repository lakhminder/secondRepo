package com.thoughtworks.assignment1.code.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Session {

	private List<Talks> talkList = new ArrayList<Talks>();
	private Calendar cal;
	private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("hh:mma");
	private Integer leftOverDuration;
	
	public Session(Integer leftOverDuration, Calendar cal) {
		super();
		this.leftOverDuration = leftOverDuration;
		this.cal = cal;
	}
	
	public List<Talks> getTalkList() {
		return talkList;
	}
	public void setTalkList(List<Talks> talkList) {
		this.talkList = talkList;
	}
	public Calendar getCal() {
		return cal;
	}
	public void setCal(Calendar cal) {
		this.cal = cal;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Talks talks : talkList){
		Date date = cal.getTime();
		sb.append("\n");
		sb.append(SIMPLE_DATE_FORMAT.format(date));
		sb.append(" ");
		sb.append(talks);
		
		cal.add(Calendar.MINUTE, talks.getDuration());
		
		}
		return sb.toString();
		
	}
	
	public Integer getLeftOverDuration() {
		return leftOverDuration;
	}
	public void setLeftOverDuration(Integer leftOverDuration) {
		this.leftOverDuration = leftOverDuration;
	}
	
	public void addTalk(Talks talk){
		this.talkList.add(talk);
		this.leftOverDuration = this.leftOverDuration - talk.getDuration();
	}
	
	
}
