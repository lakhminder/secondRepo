package com.thoughtworks.assignment1.code;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.thoughtworks.assignment1.code.model.Session;
import com.thoughtworks.assignment1.code.model.Talks;
import com.thoughtworks.assignment1.code.model.Track;

public class ConferenceTrackFactory {

	public List<Track> getTracks(List<Talks> talkList){
		List<Track> trackList = new ArrayList<Track>();
		int trackCount = 1;
		Track track = createTrack("Track " + trackCount++);
		Session currentMorningSession = track.getMorningSession();
		Session currentAfternoonSession = track.getAfternoonSession();
		
		for(Talks talk : talkList){
			
			if(currentMorningSession.getLeftOverDuration() > talk.getDuration() ){
				currentMorningSession.addTalk(talk);
			}else if(currentAfternoonSession.getLeftOverDuration() > talk.getDuration()){
				currentAfternoonSession.addTalk(talk);
			}else{
				//Adjust the networking Event time
				track.getNetworkingEvent().getCal().add(Calendar.MINUTE, -track.getAfternoonSession().getLeftOverDuration());
				trackList.add(track);
				track = createTrack("Track " + trackCount++);
				currentMorningSession = track.getMorningSession();
				currentAfternoonSession = track.getAfternoonSession();
				currentMorningSession.addTalk(talk);
			}
		}
		//Adjust the networking Event time
		track.getNetworkingEvent().getCal().add(Calendar.MINUTE, -track.getAfternoonSession().getLeftOverDuration());
		trackList.add(track);
		return trackList;
	}
	
	private Track createTrack(String trackName){
		Track track = new Track(trackName);
		Calendar morningCal = new GregorianCalendar(0, 0, 0, 9, 0);
		Calendar afternoonCal = new GregorianCalendar(0, 0, 0, 13, 0);
		Session morningSession = new Session(180, morningCal);
		Session afternoonSession = new Session(240, afternoonCal);
		track.setMorningSession(morningSession);
		track.setAfternoonSession(afternoonSession);
		
		//Set the Lunch for Track
		Talks lunchTalk = new Talks();
		lunchTalk.setDuration(60);
		lunchTalk.setTitle("Lunch");
		Calendar cal = new GregorianCalendar(0, 0, 0, 12, 0);
		Session lunchSession = new Session(60, cal);
		lunchSession.getTalkList().add(lunchTalk);
		track.setLunchSession(lunchSession);
		
		//Set the Networking Event for Track
		Talks networkingEventTalk = new Talks();
		networkingEventTalk.setDuration(60);
		networkingEventTalk.setTitle("Networking Event");
		Calendar networkCal = new GregorianCalendar(0, 0, 0, 17, 0);
		Session networkingEvent = new Session(60, networkCal);
		networkingEvent.getTalkList().add(networkingEventTalk);
		track.setNetworkingEvent(networkingEvent);
		
		return track;
	}
	
	
	
}
