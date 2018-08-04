package org.lucky.projects.maven.jersey.messenger.example9Hateoas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.lucky.projects.maven.jersey.messenger.example9Hateoas.db.DBStub;
import org.lucky.projects.maven.jersey.messenger.example9Hateoas.model.Profile;


public class ProfileService {

	private Map<String, Profile> profiles = DBStub.getProfiles();
	
	public ProfileService() {
		profiles.put("Lucky", new Profile(1L, "Lucky", "First Name", "Last Name"));
	}
	
	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values()); 
	}
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if (profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}
	
	
}
