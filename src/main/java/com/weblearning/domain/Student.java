package com.weblearning.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.weblearning.security.model.User;


@Entity
@DiscriminatorValue("Student")
public class Student extends User{
	
	public Student() {
		
	}

}
