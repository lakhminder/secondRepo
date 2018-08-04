package com.thoughtworks.assignment1.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.assignment1.code.ConferenceTrackFactory;
import com.thoughtworks.assignment1.code.model.Talks;
import com.thoughtworks.assignment1.code.model.Track;

/**
 * 
 * This class is for Testing the output.
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			//Create Talks object based on input
			List<Talks> talksList = createInput();
			ConferenceTrackFactory trackFactory = new ConferenceTrackFactory();
			List<Track> trackList = trackFactory.getTracks(talksList);
			for(Track track : trackList){
				System.out.println(track);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	public static List<Talks> createInput() throws Exception{
		FileReader inputFile = new FileReader("src/com/thoughtworks/assignment1/input/input.txt");
		BufferedReader fileReader = new BufferedReader(inputFile);
		String inputTalk = null;
		List<Talks> inputList = new ArrayList<Talks>();
		while((inputTalk = fileReader.readLine()) != null){
			Talks talks = new Talks();
			if(inputTalk.endsWith("lightning")){
				talks.setDuration(5);
				talks.setTitle(inputTalk.substring(0, inputTalk.indexOf("lightning") - 1));
			}else
			{
				String duration = inputTalk.substring(inputTalk.lastIndexOf(" ") + 1);
				talks.setDuration(Integer.valueOf(duration.replaceAll("min","")));
				talks.setTitle(inputTalk.substring(0, inputTalk.lastIndexOf(" ")));
			}
			inputList.add(talks);
		}
		
		return inputList;
	}

}
