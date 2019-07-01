package com.weblearning.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weblearning.security.model.User;

import javax.persistence.JoinColumn;


@Entity
@Table(name="grade")
public class Grade {

	int gradeId;
	String gradeName;
	
	private Set<Subject> subjects = new HashSet<Subject>(0);
	//many to many between tutor and grade and grade receivinf side
	private Set<User> users = new HashSet<User>(0);

	public Grade(){
	}
	
	public Grade(int gradeId, String gName, Set<Subject> subjects) {
		this.gradeId = gradeId;
		this.gradeName = gName;
		this.subjects = subjects;
	}
	
	@Id
    @Column(name="GRADEID")
	public int getGradeId(){
		return gradeId;
	}
	
	public void setGradeId(int id){
		gradeId = id;
	}
	
	
	@Column(name="GRADENAME")
	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String grade) {
		this.gradeName = grade;
	}
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "grade_subject", joinColumns = { 
			@JoinColumn(name = "GRADEID", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "SUBJECTID", 
					nullable = false, updatable = false) })
	public Set <Subject> getSubjects(){
		return subjects;
	}
	
	
	public void setSubjects(Set <Subject>subs){
		subjects = subs;
	}
	
	
	//many to many relatioship between tutor and grade
	@ManyToMany(mappedBy = "gradeTutor")
	public Set<User> getUsers() {
		return this.users;
	}
	public void setUsers(Set<User> gt) {
		this.users = gt;
	}
	

}
