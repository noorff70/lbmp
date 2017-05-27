package com.weblearning.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TOPICDETAIL")
public class TopicDetail implements Serializable
{
		
	private static final long serialVersionUID = 1L;
	
	int topicDetailsID;
	String topicDetailName;
	String className;
	Topic topic;
	
	TopicDetail(){
	}
	
	@Id
	@Column(name="TOPICDETAILID")
	public int getTopicDetailsID() {
		return topicDetailsID;
	}
	public void setTopicDetailsID(int topicDetailsID) {
		this.topicDetailsID = topicDetailsID;
	}
	
	@Column(name="TOPICDETAILNAME")
	public String getTopicDetailName() {
		return topicDetailName;
	}
	public void setTopicDetailName(String topicDetailName) {
		this.topicDetailName = topicDetailName;
	}

	@ManyToOne
	@JoinColumn(name="TOPICID")
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	public void setClassName(String class1){
		this.className = class1;
	}
	
	@Id
	@Column(name="CLASSNAME")
	public String getClassName(){
		return className;
	}
}
