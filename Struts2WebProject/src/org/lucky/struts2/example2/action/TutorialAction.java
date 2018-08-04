package org.lucky.struts2.example2.action;

import org.lucky.struts2.example2.service.TutorialBS;

public class TutorialAction {
	
	/*
	 * This has member which is used in JSP to get value from it
	 * and show it on JSP using <s:property> tag
	 * For package and namespace understanding
	 * Namespace is one which comes in url and is same as modules in struts1
	 * http://localhost:7001/Struts2WebProject/example2NameSpace/getTutorial.action
	 */
	private String TutorialSite;

	public String execute(){
		TutorialBS tutorialBS = new TutorialBS();
		setTutorialSite(tutorialBS.getTutorialSite());
		return "success";
	}

	public String getTutorialSite() {
		return TutorialSite;
	}

	public void setTutorialSite(String tutorialSite) {
		TutorialSite = tutorialSite;
	}
}
