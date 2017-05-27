package com.weblearning.domain.ui;

import java.util.List;

import com.weblearning.domain.Topic;

/*
 * This class is to render objects to UI
 */

public class UIObject {
	
	//hold the name of the web page
	String viewpage;
	//hold the list of topics
	List<Topic> topicList;
	
	public String getViewpage() {
		return viewpage;
	}
	
	public void setViewpage(String viewpage) {
		this.viewpage = viewpage;
	}
	
	public List<Topic> getTopicList() {
		return topicList;
	}
	
	public void setTopicList(List<Topic> topicList) {
		this.topicList = topicList;
	}
	
	
	

}
