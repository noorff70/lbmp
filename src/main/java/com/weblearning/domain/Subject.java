package com.weblearning.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="subject")
public class Subject {
	
	String subjectName;
	int subjectId;
	Set<Grade> grades = new HashSet<Grade>(0);

	public Subject(){
		
	}
	
	@Id
    @Column(name="SUBJECTID")
	public int getSubjectId(){
		return subjectId;
	}
	
	public void setSubjectId(int id){
		subjectId = id;
	}
	
	@Column(name="SUBJECTNAME")
	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subject) {
		this.subjectName = subject;
	}
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "subjects")
	public Set<Grade> getGrades() {
		return this.grades;
	}
 
	public void setGrades(Set<Grade> grade) {
		this.grades = grade;
	}
	
}
