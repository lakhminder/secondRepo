package com.thoughtworks.assignment1.code.model;

public class Talks {

	private String title;
	private Integer duration;

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	@Override
	public String toString(){
		return title + " " + duration + "min";
	}


}
