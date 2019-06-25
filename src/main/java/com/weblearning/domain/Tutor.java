package com.weblearning.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.weblearning.security.model.User;

@Entity
@DiscriminatorValue("Tutor")
public class Tutor extends User{
	
	public Tutor() {
		
	}

}
