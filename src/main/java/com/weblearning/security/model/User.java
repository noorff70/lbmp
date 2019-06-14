package com.weblearning.security.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/*
 * This class is used to identify the user in the system
 */

@Entity
@Table(name="LBMPUSER")
public class User{
	
	Long userId;
	
	@NotEmpty(message = "Please enter User Name.")
	String username;
	@NotEmpty
	String password;
	
	
	public User(){
		
	}
	
	
	@Id
	@Column(name="USERID")
	public Long getUserId(){
		return userId;
	}
	
	public void setUserId(Long uId){
		userId = uId;
	}
	
	@Column(name="USERNAME")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name="PASSWORD")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


}
