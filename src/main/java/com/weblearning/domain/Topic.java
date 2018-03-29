package com.weblearning.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="TOPIC")
public class Topic {
	
	int gradeId;
	int subjectId;
	int topicId;
	String topicName;
	String gradeSubject;
	Set<TopicDetail> topicDetail = new HashSet<TopicDetail>();
	
	Topic(){
	}
	
	@Column(name="GRADEID")
	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	@Column(name="SUBJECTID")
	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	@Id
	@Column(name="TOPICID")
	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	@Column(name="TOPICNAME")
	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	
	@JsonManagedReference
	@OneToMany(fetch = FetchType.EAGER,mappedBy="topic")
	public Set<TopicDetail> getTopicDetail(){
		return topicDetail;
	}

	public void setTopicDetail(Set<TopicDetail> topicDetails){
		topicDetail= topicDetails;
	}
	
	@Column(name="GRADESUBJECT")
	public String getGradeSubject(){
		return gradeSubject;
	}
	
	public void setGradeSubject(String gs){
		gradeSubject = gs;
	}

}
